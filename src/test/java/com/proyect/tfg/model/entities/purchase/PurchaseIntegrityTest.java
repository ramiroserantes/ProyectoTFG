package com.proyect.tfg.model.entities.purchase;

import com.proyect.tfg.model.entities.product.Product;
import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Purchase funciona como se espera.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto cualesquiera que deberían tener las clases que interactuan con purchase.
 */

@SpringBootTest
public class PurchaseIntegrityTest {

    private final Long defaultPremiumCoinValue = Long.valueOf(0);
    private final BigDecimal defaultRealValue = BigDecimal.ZERO;

    private final LocalDateTime defaultPurchaseDate = LocalDateTime.now();
    private final int defaultQuantity = 0;

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            Long.valueOf(0), Long.valueOf(0), BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, Long.valueOf(0), "link", true);}

    private Product getProduct() {
        Product product =  new Product();
        product.setName("default");
        return product;
    }

    private Purchase getPurchase() {return new Purchase();}

    private Purchase getPurchaseByArgsConstructor(User user, Product product) {return new Purchase(user,
            product, defaultPremiumCoinValue, defaultRealValue, defaultPurchaseDate, defaultQuantity);}

    /** Comprobamos que usando el setUser se almacene correctamente el user en purchase **/
    @Test
    public void testPurchaseByUser() {

        User expectedUser = getUser();
        Purchase purchase = getPurchase();

        purchase.setUser(expectedUser);

        assertEquals(purchase.getUser(), expectedUser);
    }

    /** Comprobamos que usando el setProduct se almacene correctamente el producto en purchase **/
    @Test
    public void testPurchaseByProduct() {

        Product expectedProduct = getProduct();
        Purchase purchase = getPurchase();

        purchase.setProduct(expectedProduct);

        assertEquals(purchase.getProduct(), expectedProduct);

    }

    /** Comprobamos que el constructor con argumentos cree bien el estado con user y product, y los demas campos **/
    @Test
    public void testPurchaseByArgsConstructor() {

        Product expectedProduct = getProduct();
        User expectedUser =  getUser();

        Purchase purchase = getPurchaseByArgsConstructor(expectedUser, expectedProduct);

        assertTrue((purchase.getUser().equals(expectedUser)) &&
                (purchase.getProduct().equals(expectedProduct)) &&
                (purchase.getPurchaseDate() == defaultPurchaseDate) &&
                (purchase.getQuantity() == defaultQuantity) &&
                (purchase.getRealValue() == defaultRealValue) &&
                (purchase.getPremiumCoinValue() == defaultPremiumCoinValue));
    }
}
