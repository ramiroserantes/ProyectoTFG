package com.proyect.tfg.model.entities.topic;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests para verificar que la clase Topic funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un topic en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class TopicUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final LocalDateTime defaultPostedDate = LocalDateTime.now();
    private final String defaultHeader = "header";
    private final String defaultContent = "content";
    private final int defaultViews = 0;

    private Topic getTopic () {return new Topic();}

    /** Comprobamos que se pueda inicializar el id de Topic **/
    @Test
    public void testTopicById() {

        Topic topic = getTopic();
        topic.setId(defaultId);

        assertEquals(topic.getId(), defaultId);
    }

    /** Comprobamos que se pueda inicializar la fecha de subida de Topic **/
    @Test
    public void testTopicByPostedDate() {

        Topic topic = getTopic();
        topic.setPostedDate(defaultPostedDate);

        assertEquals(topic.getPostedDate(), defaultPostedDate);

    }

    /** Comprobamos que se pueda inicializar el header de Topic **/
    @Test
    public void testTopicByHeader() {

        Topic topic = getTopic();
        topic.setHeader(defaultHeader);

        assertEquals(topic.getHeader(), defaultHeader);
    }

    /** Comprobamos que se pueda inicializar el contenido de Topic **/
    @Test
    public void testTopicByContent() {

        Topic topic = getTopic();
        topic.setContent(defaultContent);

        assertEquals(topic.getContent(), defaultContent);
    }

    /** Comprobamos que se pueda inicializar las vistas de Topic **/
    @Test
    public void testTopicByViews() {

        Topic topic = getTopic();
        topic.setViews(defaultViews);

        assertEquals(topic.getViews(), defaultViews);
    }


}
