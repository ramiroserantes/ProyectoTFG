package com.proyect.tfg.model.entities.product;

import com.proyect.tfg.model.entities.category.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase product funciona como se espera.  Probando siempre la mínima cantidad de código posible,
 *  existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un producto en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class ProductIntegrityTest {

    private final String defaultCategoryName = "category";

    private final Boolean defaultIsQuantityLimited = false;
    private final Long defaultGameValue = Long.valueOf(0);
    private final BigDecimal defaultRealValue = BigDecimal.ZERO;
    private final String defaultName = "name";
    private final String defaultDescription = "description";
    private final BigDecimal defaultDiscount = BigDecimal.valueOf(50.4);
    private final LocalDateTime defaultDisableDate = LocalDateTime.now();

    private Category getCategory() {
        Category category = new Category();
        category.setName(defaultCategoryName);
        return category;
    }

    private Product getProduct() {return new Product();}

    private Product getProductByArgsConstructor(Category category) {return new Product(category,
            defaultIsQuantityLimited, defaultGameValue, defaultRealValue, defaultName, defaultDescription,
            defaultDiscount, defaultDisableDate);}

    /** Comprobamos que la Categoria introducida con el set sea la que corresponde **/
    @Test
    public void testProductByCategory() {

        Category expectedCategory = getCategory();
        Product product = getProduct();

        product.setCategory(expectedCategory);

        assertEquals(product.getCategory(), expectedCategory);
    }

    /** Comprobamos que la Categoria introducida con el constructor sea la que corresponde y los
     * demás campos también **/
    @Test
    public void testProductByArgsConstructor() {

        Category expectedCategory = getCategory();
        Product product = getProductByArgsConstructor(expectedCategory);

        assertTrue((product.getCategory().equals(expectedCategory)) &&
                (product.getQuantityLimited() == defaultIsQuantityLimited) &&
                (product.getGameValue() == defaultGameValue) &&
                (product.getRealValue() == defaultRealValue) &&
                (product.getName() == defaultName) &&
                (product.getDescription() == defaultDescription) &&
                (product.getDiscount() == defaultDiscount) &&
                (product.getDisableDate() == defaultDisableDate));
    }

}
