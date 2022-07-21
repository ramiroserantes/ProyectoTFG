package com.proyect.tfg.model.entities.order;

import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Order funciona como se espera.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto cualesquiera que deberían tener las clases que interactuan con order.
 */

@SpringBootTest
public class OrderIntegrityTest {

    private final LocalDateTime defaultCreationDate = LocalDateTime.now();
    private final LocalDateTime defaultExpirationDate = LocalDateTime.now();
    private final int defaultRequiredAmount = 1;
    private final int defaultAdquiredAmount = 1;
    private final int defaultPricePerUnit = 1;
    private final Order.Status status1 = Order.Status.EXPIRED;
    private final Order.Status status2 = Order.Status.CANCELED;
    private final Order.OrderType orderType = Order.OrderType.SELLPLATINUM;

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            0L, 0L, BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, 0L, "link", true);}

    private Order getDefaultOrder() {return new Order();}

    private Order getOrder1(User user) {return new Order(user, defaultCreationDate, defaultExpirationDate,
            defaultRequiredAmount, defaultAdquiredAmount, defaultPricePerUnit, status1, orderType);}

    private Order getOrder2(User user) {return new Order(user, defaultCreationDate, defaultExpirationDate,
            defaultRequiredAmount, defaultAdquiredAmount, defaultPricePerUnit, status2, orderType);}

    private Transaction getTransaction1() {return new Transaction(getOrder1(getUser()), LocalDateTime.now(), 1,
            1);}

    private Transaction getTransaction2() {return new Transaction(getOrder2(getUser()), LocalDateTime.now(), 1,
            1);}

    /** Comprobamos que el usuario que incorporamos a Order es el que se almacena en el estado **/
    @Test
    public void testOrderByUser() {

        User expectedUser = getUser();
        Order order = getDefaultOrder();

        order.setUser(expectedUser);

        assertEquals(order.getUser(), expectedUser);
    }

    /** Comprobamos que el usuario que incorporamos a Order con ayuda del constructor en el estado es correcto y todos los demás
     * campos **/
    @Test
    public void testOrderByConstructor() {

        User expectedUser = getUser();
        Order order = getOrder1(expectedUser);

        assertTrue((order.getUser().equals(expectedUser) &&
                (order.getCreationDate() == defaultCreationDate) &&
                (order.getExpirationDate() == defaultExpirationDate) &&
                (order.getRequiredAmount() == defaultRequiredAmount) &&
                (order.getAdquiredAmount() == defaultAdquiredAmount) &&
                (order.getPricePerUnit() == defaultPricePerUnit) &&
                (order.getStatus() == status1) &&
                (order.getOrderType() == orderType)));

    }

    /** Comprobamos que las transacciones que incorporamos a order sean incorporadas correctamente al estado **/
    @Test
    public void testOrderByTransactions() {

        Order order = getOrder2(getUser());

        Set<Transaction> expectedTranctionSet = new HashSet<>();
        expectedTranctionSet.add(getTransaction1());
        expectedTranctionSet.add(getTransaction2());

        order.setTransactions(expectedTranctionSet);

        assertEquals(order.getTransactions(), expectedTranctionSet);
    }
}
