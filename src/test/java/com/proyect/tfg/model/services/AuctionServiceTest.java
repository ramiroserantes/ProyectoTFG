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

    private Order getOrder(User user, Order.Status status) {return orderDao.save(new Order(user,
            defaultCreationDate, defaultExpirationDate, defaultRequiredAmount, defaultAdquiredAmount,
            defaultPricePerUnit, status, defaultOrderType));}

    /** Se comprueba el correcto funcionamiento básico de findorders a través de la búsqueda de una
     * orden de un usuario.
     *
     *  -Datos elegidos :
     *      -Un usuario y una orden **/

    /** Errores encontrados(y solucionados):
     *  -En user, faltaba un @Colummn en rank.
     *  -En user, no existía el campo link y verified en la base de datos.
     * **/

    @Test
    public void testAuctionsByFindOrders() throws InstanceNotFoundException {

        User user = getUser();
        Order order = getOrder(user, defaultStatus);

        Block<Order> expectedOrders = new Block<>(Arrays.asList(order), false);
        Block<Order> orders = auctionService.findOrdersByUser(user.getId(), 0, 1);

        assertEquals(expectedOrders, orders);

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

}
