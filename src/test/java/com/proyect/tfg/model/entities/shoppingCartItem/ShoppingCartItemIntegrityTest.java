package com.proyect.tfg.model.entities.shoppingCartItem;

import com.proyect.tfg.model.entities.product.Product;
import com.proyect.tfg.model.entities.shoppingCart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase ShoppingCartItem funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un shoppingCartItem en la mayoria de su estado al ser creado.
 */
public class ShoppingCartItemIntegrityTest {

    private final int defaultQuantity = 0;

    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    private Product getProduct() {
        Product product = new Product();
        product.setName("default");
        return product;
    }

    private ShoppingCartItem getShoppingCartItem() {return new ShoppingCartItem();}

    private ShoppingCartItem getShoppingCartItemByArgsConstructor(ShoppingCart shoppingCart, Product product) {
        return new ShoppingCartItem(shoppingCart, product, defaultQuantity);}

    /** Comprobamos que se pueda almacenar un shoppingCart correctamente **/
    @Test
    public void testShoppingCartItemByShoppingCart() {

        ShoppingCart expectedShoppingCart = getShoppingCart();

        ShoppingCartItem shoppingCartItem = getShoppingCartItem();
        shoppingCartItem.setShoppingCart(expectedShoppingCart);

        assertEquals(shoppingCartItem.getShoppingCart(), expectedShoppingCart);

    }

    /** Comprobamos que se pueda almacenar un producto en el shoppingCartItem **/
    @Test
    public void testShoppingCartITemByProduct() {

        Product expectedProduct = getProduct();

        ShoppingCartItem shoppingCartItem = getShoppingCartItem();
        shoppingCartItem.setProduct(expectedProduct);

        assertEquals(shoppingCartItem.getProduct(), expectedProduct);
    }

    /** Comprobamos que el constructor con argumentos se inicialice de forma correcta en todos los campos **/
    @Test
    public void testShoppingCartByArgsConstructor() {

        Product expectedProduct = getProduct();
        ShoppingCart expectedShoppingCart = getShoppingCart();

        ShoppingCartItem shoppingCartItem = getShoppingCartItemByArgsConstructor(expectedShoppingCart, expectedProduct);

        assertTrue(shoppingCartItem.getProduct().equals(expectedProduct) &&
                (shoppingCartItem.getShoppingCart().equals(expectedShoppingCart)) &&
                (shoppingCartItem.getQuantity() == defaultQuantity));
    }


}
