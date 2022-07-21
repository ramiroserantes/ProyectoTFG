package com.proyect.tfg.model.entities.shoppingCartItem;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests para verificar que la clase ShoppingCartItem funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un shoppingCartItem en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class ShoppingCartItemUnitTest {

    private final Long defaultId = Long.valueOf(1);
    private final int defaultQuantity = 0;

    private ShoppingCartItem getShoppingCartItem() {return new ShoppingCartItem();}

    /** Comprobamos que se pueda inicializar el id del shoppingCartItem **/
    @Test
    public void testShoppingCartItemById() {

        ShoppingCartItem shoppingCartItem = getShoppingCartItem();
        shoppingCartItem.setId(defaultId);

        assertEquals(shoppingCartItem.getId(), defaultId);

    }

    /** Comprobamos que se pueda inicializar la cantidad del shoppingCartItem **/
    @Test
    public void testShoppingCartItemByQuantity() {

        ShoppingCartItem shoppingCartItem = getShoppingCartItem();
        shoppingCartItem.setQuantity(defaultQuantity);

        assertEquals(shoppingCartItem.getQuantity(), defaultQuantity);

    }

}
