package com.proyect.tfg.model.services;

import com.proyect.tfg.model.entities.order.Order;
import com.proyect.tfg.model.entities.order.OrderDao;
import com.proyect.tfg.model.entities.user.User;
import com.proyect.tfg.model.entities.user.UserDao;
import com.proyect.tfg.model.exceptions.InstanceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/** Tests para comprobar el correcto funcionamiento de las funcionalidades del servicio de Auctions, se
 * probará la mínima cantidad en cada test.
 *
 * - Nivel: Debido a que en los servicios inter-operan diferentes unidades entre sí, son tests de integridad.
 *
 * - Categoría: Pruebas de caja negra funcionales positivas.
 *
 * - Datos Elegidos:
 *      Se especificará en cada caso la selección de datos.
 */

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class AuctionServiceTest {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuctionService auctionService;

    private final Long NON_EXISTENT_ID = -1L;
    private final LocalDateTime defaultCreationDate = LocalDateTime.now();
    private final LocalDateTime defaultExpirationDate = LocalDateTime.now();
    private final int defaultRequiredAmount = 0;
    private final int defaultAdquiredAmount = 0;
    private final int defaultPricePerUnit = 0;
    private final Order.Status defaultStatus = Order.Status.ACTIVE;
    private final Order.OrderType defaultOrderType = Order.OrderType.BUYPLATINUM;

    private User getUser() {return userDao.save(new User("userName", "password", "email", User.WebRole.USER,
            0L, 0L, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, 0L, "link", true));}

    private Order getOrder(User user, Order.Status status, LocalDateTime creationDate, LocalDateTime expirationDateDate,
                           Order.OrderType orderType)
        {return orderDao.save(new Order(user, creationDate, expirationDateDate, defaultRequiredAmount, defaultAdquiredAmount,
            defaultPricePerUnit, status, orderType));}

    /** Se comprueba el correcto funcionamiento básico de findorders a través de la búsqueda de una
     * orden de un usuario.
     *
     *  -Datos elegidos :
     *      -Un usuario y una orden **/

    /** Errores encontrados(y solucionados):
     *  -En user, faltaba un @Colummn en rank.
     *  -En user, no existía el campo link y verified en la base de datos.
     *  -En el dao al buscar se referenciaba al orderId en vez de al userId
     * **/

    @Test
    public void testAuctionsByFindOrders() throws InstanceNotFoundException {

        User user = getUser();
        Order order = getOrder(user, defaultStatus, defaultCreationDate, defaultExpirationDate.plusHours(1L), defaultOrderType);

        Block<Order> expectedOrders = new Block<>(Arrays.asList(order), false);

        assertEquals(expectedOrders, auctionService.findOrdersByUser(user.getId(), 0, 2));

    }

    /** Comprobamos que se lance la excepción del usuario no existente al introducir el id incorrecto
     *
     * - Datos Elegidos:
     *      - Un usuario y un id inválido
     * **/
    @Test
    public void testAuctionsByFindOrdersWithInvalidId() throws InstanceNotFoundException {

        assertThrows(InstanceNotFoundException.class, () -> auctionService.findOrdersByUser(NON_EXISTENT_ID, 0, 1));

    }

    /** Comprobamos que el servicio devuelva de forma correcta ordenes expiradas en el caso de que una activa haya expirado
     *
     * - Datos Elegidos:
     *  - Un usuario cualquiera y una orden con la fecha anterior a ahora.
     * */
    @Test
    public void testAuctionsByFindOrdersByExpired() throws InstanceNotFoundException {

        User user = getUser();
        Order expectedOrder = getOrder(user, defaultStatus, defaultCreationDate, LocalDateTime.now().minusHours(1L), defaultOrderType);

        expectedOrder.setStatus(Order.Status.EXPIRED);

        Block<Order> orders = auctionService.findOrdersByUser(user.getId(), 0, 2);

        assertEquals(orders.getItems().get(0), expectedOrder);
    }

    /** Comprobamos que el servicio funcione con paginación
     *
     * - Datos Elegidos:
     *  - Un usuario, 2 ordenes cualesquiera.
     * **/

    @Test
    public void testAuctionsByFindOrdersByPagination() throws InstanceNotFoundException {

        User user = getUser();
        Order order1 = getOrder(user, Order.Status.ACTIVE, defaultCreationDate, LocalDateTime.now().plusHours(1L), defaultOrderType);
        Order order2 = getOrder(user, Order.Status.CANCELED, defaultCreationDate, LocalDateTime.now().minusHours(1L), defaultOrderType);

        Block<Order> expectedOrderBlock1 = new Block<>(Arrays.asList(order1), true);
        Block<Order> expectedOrderBlock2 = new Block<>(Arrays.asList(order2), false);
        Block<Order> orders1 = auctionService.findOrdersByUser(user.getId(), 0, 1);
        Block<Order> orders2 = auctionService.findOrdersByUser(user.getId(), 1, 1);

        assertTrue((expectedOrderBlock1.equals(orders1)) &&
                    (expectedOrderBlock2.equals(orders2)));
    }

    /** Comprobamos que una vez paginado devuelva los datos ordenados por el estado y la fecha de creación
     *
     * Ordenes establecidos en los requisitos:
     * Orden de status = Primero se muestra activo, cancelado y expirado.
     * Orden de Type = Primero se muestran las ventas y luego las compras.
     * Orden de Fecha = Primero se muestran las mas nuevas y luego las más antiguas.
     *
     *  - Datos Elegidos:
     *      - 5 Órdenes (1 activa con fecha de expiración, 2 canceladas una más antigua y de diferente tipo, 1 activa pero tenía que estar expirada,
     *      1 expirada y más nueva que la anterior por ello se tendrá que mostrar primero.)
     *      - 1 Usuario
     *  **/

    @Test
    public void testAuctionsByFindOrdersByOrdenation() throws InstanceNotFoundException {

        User user = getUser();

        Order order1 = getOrder(user, Order.Status.ACTIVE, LocalDateTime.now().minusDays(2L), LocalDateTime.now().plusHours(1L), defaultOrderType);
        Order order2 = getOrder(user, Order.Status.CANCELED, LocalDateTime.now().minusDays(2L), LocalDateTime.now().minusHours(2L), defaultOrderType);
        Order order3 = getOrder(user, Order.Status.CANCELED, LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusHours(2L), Order.OrderType.SELLPLATINUM);

        Order order4 = getOrder(user, Order.Status.ACTIVE, LocalDateTime.now().minusHours(10L), LocalDateTime.now().minusHours(4L), Order.OrderType.SELLPLATINUM);
        order4.setStatus(Order.Status.EXPIRED);
        Order order5 = getOrder(user, Order.Status.EXPIRED, LocalDateTime.now().minusHours(6L), LocalDateTime.now().minusHours(2L), defaultOrderType);
        Order order6 = getOrder(user, Order.Status.EXPIRED, LocalDateTime.now().minusHours(3L), LocalDateTime.now().minusHours(3L), defaultOrderType);

        Block<Order> expectedBlock1 = new Block<>(Arrays.asList(order1, order3, order2), true);
        Block<Order> expectedBlock2 = new Block<>(Arrays.asList(order4, order6, order5), false);

        Block<Order> orders1 = auctionService.findOrdersByUser(user.getId(), 0, 3);
        Block<Order> orders2 = auctionService.findOrdersByUser(user.getId(), 1 ,3);

        assertTrue(orders1.equals(expectedBlock1) && (orders2.equals(expectedBlock2)));

    }

}
