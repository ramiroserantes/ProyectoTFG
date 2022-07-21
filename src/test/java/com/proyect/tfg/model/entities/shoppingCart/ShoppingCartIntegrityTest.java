package com.proyect.tfg.model.entities.shoppingCart;

import com.proyect.tfg.model.entities.shoppingCartItem.ShoppingCartItem;
import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase ShoppingCart funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un shoppingCart en la mayoria de su estado al ser creado.
 */
public class ShoppingCartIntegrityTest {

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            Long.valueOf(0), Long.valueOf(0), BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, Long.valueOf(0), "link", true);}

    private ShoppingCartItem getShoppingCartItem(int quantity) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setQuantity(quantity);
        return shoppingCartItem;
    }

    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    /** Comprobamos que se pueda introducir un usuario con el setUser **/
    @Test
    public void testShoppingCartByUser() {

        User expectedUser = getUser();
        ShoppingCart shoppingCart = getShoppingCart();

        shoppingCart.setUser(expectedUser);

        assertEquals(shoppingCart.getUser(), expectedUser);
    }

    /** Comprobamos que se pueda incorporar varios shoppingCartItem al shoppingCart **/
    @Test
    public void testShoppingCartByShoppingCartItem() {

        ShoppingCartItem expectedShoppingCartItem1 = getShoppingCartItem(1);
        ShoppingCartItem expectedShoppingCartItem2 = getShoppingCartItem(2);
        Set<ShoppingCartItem> expectedShoppingCartsItems = new HashSet<>();
        expectedShoppingCartsItems.add(expectedShoppingCartItem1);
        expectedShoppingCartsItems.add(expectedShoppingCartItem2);

        ShoppingCart shoppingCart = getShoppingCart();

        shoppingCart.setItems(expectedShoppingCartsItems);

        assertEquals(shoppingCart.getItems(), expectedShoppingCartsItems);


    }
}
