package com.proyect.tfg.model.entities.reply;

import com.proyect.tfg.model.entities.topic.Topic;
import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Reply funciona como se espera.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto cualesquiera que deberían tener las clases que interactuan con Reply.
 */
@SpringBootTest
public class ReplyIntegrityTest {

    private final String defaultContent = "Content";
    private final Boolean defaultIsEdited = false ;
    private final LocalDateTime defaultPostedDate = LocalDateTime.now();
    private final LocalDateTime defaultEditedDate = LocalDateTime.now();

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            Long.valueOf(0), Long.valueOf(0), BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, Long.valueOf(0), "link", true);}

    private Topic getTopic() {
        Topic topic = new Topic();
        topic.setContent("default");
        return topic;
    }

    private Reply getReply() {return new Reply();}

    private Reply getReplyByArgsConstructor(User user, Topic topic) {return new Reply(
        topic, user, defaultContent, defaultIsEdited, defaultPostedDate, defaultEditedDate);}

    /** Comprobamos que se pueda almacenar el usuario con el setUser **/
    @Test
    public void testReplyByUser() {

        User expectedUser = getUser();
        Reply reply = getReply();

        reply.setUser(expectedUser);

        assertEquals(reply.getUser(), expectedUser);
    }

    /**Comprobamos que se pueda almacenar un topic con el SetTopic **/
    @Test
    public void testReplyByTopic() {

        Topic expectedTopic = getTopic();
        Reply reply = getReply();

        reply.setTopic(expectedTopic);

        assertEquals(reply.getTopic(), expectedTopic);
    }

    /**Comprobamos que el constructor con argumentos inicialice correctamente los campos **/
    @Test
    public void testReplyByArgsConstructor() {

        User expectedUser = getUser();
        Topic expectedTopic = getTopic();

        Reply reply = getReplyByArgsConstructor(expectedUser, expectedTopic);

        assertTrue((reply.getTopic().equals(expectedTopic)) &&
                (reply.getUser()).equals(expectedUser) &&
                (reply.getEdited() == defaultIsEdited) &&
                (reply.getContent() == defaultContent) &&
                (reply.getEditedDate() == defaultEditedDate) &&
                (reply.getPostedDate() == defaultPostedDate));
    }


}
