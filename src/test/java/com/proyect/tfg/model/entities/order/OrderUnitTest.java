package com.proyect.tfg.model.entities.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase Order funciona como se espera.  Probando siempre la mínima cantidad de código posible,
 *  existiendo un único assert por test. Se comprueba que se cree bien el estado en la clase, y el control de valores en los servicios.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una orden en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class OrderUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final LocalDateTime defaultCreationDate = LocalDateTime.now();
    private final LocalDateTime defaultExpirationDate = LocalDateTime.now();
    private final int defaultRequiredAmount = 0;
    private final int defaultAdquiredAmount = 0;
    private final int defaultPricePerUnit = 0;
    private final Order.Status defaultStatus = Order.Status.ACTIVE;
    private final Order.OrderType defaultOrderType = Order.OrderType.BUYPLATINUM;

    private Order getOrder() {return new Order();}

    /** Comprobamos que se pueda inicializar el id de order **/
    @Test
    public void testOrderById() {

        Order order = getOrder();
        order.setId(defaultId);

        assertEquals(order.getId(), defaultId);
    }

    /** Comprobamos que se pueda inicializar el creationDate de order **/
    @Test
    public void testOrderByCreationDate() {

        Order order = getOrder();
        order.setCreationDate(defaultCreationDate);

        assertEquals(order.getCreationDate(), defaultCreationDate);
    }

    /** Comprobamos que se pueda inicializar el expirationDate de order **/
    @Test
    public void testOrderByExpirationDate() {

        Order order = getOrder();
        order.setExpirationDate(defaultExpirationDate);

        assertEquals(order.getExpirationDate(), defaultExpirationDate);
    }

    /** Comprobamos que se pueda inicializar el requiredAmount de order **/
    @Test
    public void testOrderByRequiredAmount() {

        Order order = getOrder();
        order.setRequiredAmount(defaultRequiredAmount);

        assertEquals(order.getRequiredAmount(), defaultRequiredAmount);
    }

    /** Comprobamos que se pueda inicializar el adquiredAmount de order **/
    @Test
    public void testOrderByAdquiredAmount() {

        Order order = getOrder();
        order.setAdquiredAmount(defaultAdquiredAmount);

        assertEquals(order.getAdquiredAmount(), defaultAdquiredAmount);
    }

    /** Comprobamos que se pueda inicializar el precio por unidad de order **/
    @Test
    public void testOrderByPricePerUnit() {

        Order order = getOrder();
        order.setPricePerUnit(defaultPricePerUnit);

        assertEquals(order.getPricePerUnit(), defaultPricePerUnit);
    }

    /** Comprobamos que se pueda inicializar el status de order **/
    @Test
    public void testOrderByStatus() {

        Order order = getOrder();
        order.setStatus(defaultStatus);

        assertEquals(order.getStatus(), defaultStatus);
    }

    /** Comprobamos que se pueda inicializar el orderType de order **/
    @Test
    public void testOrderByOrderType() {

        Order order = getOrder();
        order.setOrderType(defaultOrderType);

        assertEquals(order.getOrderType(), defaultOrderType);
    }
}
