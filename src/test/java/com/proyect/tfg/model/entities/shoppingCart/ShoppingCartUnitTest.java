package com.proyect.tfg.model.entities.shoppingCart;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase ShoppingCart funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un shoppingCart en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class ShoppingCartUnitTest {

    private final Long defaultId = Long.valueOf(0);

    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    /** Comprobamos que se pueda inicializar el id del shoppingCart **/
    @Test
    public void testShoppingCartById() {

        ShoppingCart shoppingCart = getShoppingCart();
        shoppingCart.setId(defaultId);

        assertEquals(shoppingCart.getId(), defaultId);
    }

}
