package com.proyect.tfg.model.entities.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase product funciona como se espera.  Probando siempre la mínima cantidad de código posible,
 *  existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un producto en la mayoria de su estado al ser creado.
 */

/** Error encontrado(y solucionado): En la relación con purchase la participación tiene que ser total  **/

@SpringBootTest
public class ProductUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final Boolean defaultIsQuantityLimited = false;
    private final Long defaultGameValue = Long.valueOf(0);
    private final BigDecimal defaultRealValue = BigDecimal.ZERO;
    private final String defaultName = "name";
    private final String defaultDescription = "description";
    private final BigDecimal defaultDiscount = BigDecimal.valueOf(50.4);
    private final LocalDateTime defaultDisableDate = LocalDateTime.now();

    private Product getProduct() {return new Product();}

    /** Comprobamos que se inicie correctamente el id de product **/
    @Test
    public void testProductById() {

        Product product = getProduct();
        product.setId(defaultId);

        assertEquals(product.getId(), defaultId);
    }

    /** Comprobamos que se pueda declarar cantidad limitada en product **/
    @Test
    public void testProductByIsQuantityLimited() {

        Product product = getProduct();
        product.setQuantityLimited(defaultIsQuantityLimited);

        assertEquals(product.getQuantityLimited(), defaultIsQuantityLimited);
    }

    /** Comprobamos que se inicie correctamente el game value de product **/
    @Test
    public void testProductByGameValue() {

        Product product = getProduct();
        product.setGameValue(defaultGameValue);

        assertEquals(product.getGameValue(), defaultGameValue);
    }

    /** Comprobamos que se inicie correctamente el real value de product **/
    @Test
    public void testProductByRealValue() {

        Product product = getProduct();
        product.setRealValue(defaultRealValue);

        assertEquals(product.getRealValue(), defaultRealValue);
    }

    /** Comprobamos que se inicie correctamente el name de product **/
    @Test
    public void testProductByName() {

        Product product = getProduct();
        product.setName(defaultName);

        assertEquals(product.getName(), defaultName);
    }

    /** Comprobamos que se inicie correctamente la description de product **/
    @Test
    public void testProductByDescription() {

        Product product = getProduct();
        product.setDescription(defaultDescription);

        assertEquals(product.getDescription(), defaultDescription);
    }

    /** Comprobamos que se inicie correctamente el descuento de product **/
    @Test
    public void testProductByDiscount() {

        Product product = getProduct();
        product.setDiscount(defaultDiscount);

        assertEquals(product.getDiscount(), defaultDiscount);
    }

    /** Comprobamos que se inicie correctamente el disableDate de product **/
    @Test
    public void testProductByDisableDate() {

        Product product = getProduct();
        product.setDisableDate(defaultDisableDate);

        assertEquals(product.getDisableDate(), defaultDisableDate);
    }
}
