package com.proyect.tfg.model.entities.reply;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests para verificar que la clase Reply funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una reply en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class ReplyUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final String defaultContent = "Content";
    private final Boolean defaultIsEdited = false ;
    private final LocalDateTime defaultPostedDate = LocalDateTime.now();
    private final LocalDateTime defaultEditedDate = LocalDateTime.now();

    private Reply getReply() {return new Reply();}

    /** Comprobamos que el id de la Reply pueda ser inicializada **/
    @Test
    public void testReplyById() {

        Reply reply = getReply();
        reply.setId(defaultId);

        assertEquals(reply.getId(), defaultId);
    }

    /** Comprobamos que el contenido por defecto de la Reply pueda ser inicializado **/
    @Test
    public void testReplyByContent() {

        Reply reply = getReply();
        reply.setContent(defaultContent);

        assertEquals(reply.getContent(), defaultContent);
    }

    /** Comprobamos que se pueda modificar el booleano que indica que se ha editado la Reply **/
    @Test
    public void testReplyByEdited() {

        Reply reply = getReply();
        reply.setEdited(defaultIsEdited);

        assertEquals(reply.getEdited(), defaultIsEdited);
    }

    /** Comprobamos que se pueda inicializar la PostedDate de la reply **/
    @Test
    public void testReplyByPostedDate() {

        Reply reply = getReply();
        reply.setPostedDate(defaultPostedDate);

        assertEquals(reply.getPostedDate(), defaultPostedDate);
    }

    /** Comprobamos que se pueda inicializar la EditedDate de la reply **/
    @Test
    public void testReplyByEditedDate() {

        Reply reply = getReply();
        reply.setEditedDate(defaultEditedDate);

        assertEquals(reply.getEditedDate(), defaultEditedDate);
    }
}
