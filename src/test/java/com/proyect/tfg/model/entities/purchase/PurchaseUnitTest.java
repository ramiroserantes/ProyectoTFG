package com.proyect.tfg.model.entities.purchase;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase purchase funciona como se espera.  Probando siempre la mínima cantidad de código posible,
 *  existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una compra en la mayoria de su estado al ser creado.
 */

/** Error encontrado(y solucionado): No se puede almacenar el productName ahora que es una participación total **/

@SpringBootTest
public class PurchaseUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final Long defaultPremiumCoinValue = Long.valueOf(0);
    private final BigDecimal defaultRealValue = BigDecimal.ZERO;

    private final LocalDateTime defaultPurchaseDate = LocalDateTime.now();
    private final int defaultQuantity = 0;

    private Purchase getPurchase() {return new Purchase();}

    /** Comprobamos que se pueda iniciar correctamente el id de purchase **/
    @Test
    public void testPurchaseById() {

        Purchase purchase = getPurchase();
        purchase.setId(defaultId);

        assertEquals(purchase.getId(), defaultId);
    }

    /** Comprobamos que se pueda iniciar correctamente el premium coin de purchase **/
    @Test
    public void testPurchaseByPremiumCoinValue() {

        Purchase purchase = getPurchase();
        purchase.setPremiumCoinValue(defaultPremiumCoinValue);

        assertEquals(purchase.getPremiumCoinValue(), defaultPremiumCoinValue);
    }

    /** Comprobamos que se pueda iniciar correctamente el real value de purchase **/
    @Test
    public void testPurchaseByRealValue() {

        Purchase purchase = getPurchase();
        purchase.setRealValue(defaultRealValue);

        assertEquals(purchase.getRealValue(), defaultRealValue);
    }

    /** Comprobamos que se pueda iniciar correctamente la fecha de compra de purchase **/
    @Test
    public void testPurchaseByPurchaseDate() {

        Purchase purchase = getPurchase();
        purchase.setPurchaseDate(defaultPurchaseDate);

        assertEquals(purchase.getPurchaseDate(), defaultPurchaseDate);
    }

    /** Comprobamos que se pueda iniciar correctamente la cantidad de purchase **/
    @Test
    public void testPurchaseByQuantity() {

        Purchase purchase = getPurchase();
        purchase.setQuantity(defaultQuantity);

        assertEquals(purchase.getQuantity(), defaultQuantity);
    }




}
