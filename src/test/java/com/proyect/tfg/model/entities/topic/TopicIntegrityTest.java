package com.proyect.tfg.model.entities.topic;

import com.proyect.tfg.model.entities.reply.Reply;
import com.proyect.tfg.model.entities.topicCategory.TopicCategory;
import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Topic funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un topic en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class TopicIntegrityTest {

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            Long.valueOf(0), Long.valueOf(0), BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, Long.valueOf(0), "link", true);}

    private Reply getReply(String content) {
        Reply reply = new Reply();
        reply.setContent(content);
        return reply;
    }

    private TopicCategory getTopicCategory() {return new TopicCategory("default");}

    private final LocalDateTime defaultPostedDate = LocalDateTime.now();
    private final String defaultHeader = "header";
    private final String defaultContent = "content";
    private final int defaultViews = 0;

    private Topic getTopic() {return new Topic();}

    private Topic getTopicByArgsConstructor(User user, TopicCategory topicCategory) {return new Topic(user,
            topicCategory, defaultPostedDate, defaultHeader, defaultContent, defaultViews); }

    /** Comprobamos que se pueda introducir un usuario dentro de Topic con el set **/
    @Test
    public void testTopicByUser() {

        User expectedUser = getUser();
        Topic topic = getTopic();

        topic.setUser(expectedUser);

        assertEquals(topic.getUser(), expectedUser);
    }

    /** Comprobamos que se pueda introducir un conjunto de replys en Topic con el set **/
    @Test
    public void testTopicByReplies() {

        Reply expectedReply1 = getReply("1");
        Reply expectedReply2 = getReply("2");
        Set<Reply> expectedReplies = new HashSet<>();
        expectedReplies.add(expectedReply1);
        expectedReplies.add(expectedReply2);

        Topic topic = getTopic();
        topic.setReplies(expectedReplies);

        assertEquals(topic.getReplies(), expectedReplies);

    }

    /** Comprobamos que se pueda inicializar un topicCategory en topic con el set **/
    @Test
    public void testTopicByTopicCategory() {

        TopicCategory expectedTopicCategory = getTopicCategory();
        Topic topic = getTopic();

        topic.setTopicCategory(expectedTopicCategory);

        assertEquals(topic.getTopicCategory(), expectedTopicCategory);
    }

    /** Comprobamos que el constructor con argumentos inicialice bien todos los campos **/
    @Test
    public void testTopicByArgsConstructor() {

        TopicCategory expectedTopicCategory = getTopicCategory();
        User expectedUser = getUser();

        Topic topic = getTopicByArgsConstructor(expectedUser, expectedTopicCategory);

        assertTrue((topic.getUser().equals(expectedUser)) &&
                (topic.getTopicCategory().equals(expectedTopicCategory)) &&
                (topic.getViews() == defaultViews) &&
                (topic.getContent() == defaultContent) &&
                (topic.getHeader() == defaultHeader) &&
                (topic.getPostedDate() == defaultPostedDate));

    }
}
