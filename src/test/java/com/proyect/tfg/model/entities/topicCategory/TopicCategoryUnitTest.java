package com.proyect.tfg.model.entities.topicCategory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests para verificar que la clase TopicCategory funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un topic category en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class TopicCategoryUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final String defaultName = "name";

    private TopicCategory getTopicCategory() {return new TopicCategory();}

    private TopicCategory getTopicCategoryByArgsConstructor() {return new TopicCategory(defaultName);}

    /** Comprobamos que se pueda inicializar el id de Topic Category **/
    @Test
    public void testByTopicCategoryId() {

        TopicCategory topicCategory = getTopicCategory();
        topicCategory.setId(defaultId);

        assertEquals(topicCategory.getId(), defaultId);

    }

    /** Comprobamos que se pueda inicializar el name de Topic Category **/
    @Test
    public void testByTopicCategoryName() {

        TopicCategory topicCategory = getTopicCategory();
        topicCategory.setName(defaultName);

        assertEquals(topicCategory.getName(), defaultName);

    }

    /** Comprobamos que el constructor de TopicCategory con argumentos actualice el estado correctamente**/
    @Test
    public void testTopicByArgsConstructor() {

        TopicCategory topicCategory = getTopicCategoryByArgsConstructor();

        assertEquals(topicCategory.getName(), defaultName);

    }
}
