package com.proyect.tfg.model.entities.category;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase Category funciona como se espera.  Probando siempre la mínima cantidad de código posible,
 *  existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una categoria en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class CategoryUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final String defaultName = "name";
    private final String defaultDescription = "description";
    private final String defaultLink = "link/link";

    private Category getCategory() {return new Category();}

    private Category getCategoryByArgsConstructor() {return new Category(defaultName, defaultDescription, defaultLink);}

    /** Comprobamos que podemos inicializar el id de category **/
    @Test
    public void testCategoryById() {

        Category category = getCategory();
        category.setId(defaultId);

        assertEquals(category.getId(), defaultId);
    }

    /** Comprobamos que podemos inicializar el nombre de category **/
    @Test
    public void testCategoryByName() {

        Category category = getCategory();
        category.setName(defaultName);

        assertEquals(category.getName(), defaultName);
    }

    /** Comprobamos que podemos inicializar la description de category **/
    @Test
    public void testCategoryByDescription() {

        Category category = getCategory();
        category.setDescription(defaultDescription);

        assertEquals(category.getDescription(), defaultDescription);
    }

    /** Comprobamos que podemos inicializar el link de category **/
    @Test
    public void testCategoryByLink() {

        Category category = getCategory();
        category.setLink(defaultLink);

        assertEquals(category.getLink(), defaultLink);
    }

    /** Comprobamos que el constructor con argumentos actualice el estado correctamente **/
    @Test
    public void testCategoryByConstructor() {

        Category category = getCategoryByArgsConstructor();

        assertTrue((category.getName() == defaultName) &&
                (category.getDescription() == defaultDescription) &&
                (category.getLink() == defaultLink));
    }

}
