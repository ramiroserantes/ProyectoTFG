package com.proyect.tfg.model.entities.user;

import com.proyect.tfg.model.entities.order.Order;
import com.proyect.tfg.model.entities.purchase.Purchase;
import com.proyect.tfg.model.entities.reply.Reply;
import com.proyect.tfg.model.entities.shoppingCart.ShoppingCart;
import com.proyect.tfg.model.entities.topic.Topic;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase Usuario funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un usuario en la mayoria de su estado al ser creado.
 */
@SpringBootTest
public class UserIntegrityTest {

    private ShoppingCart getShoppingCart() {return new ShoppingCart();}

    private User getUser() {return new User();}

    /** Comprobamos que se puedan asignar ordenes a un usuario **/
    @Test
    public void testUserByOrders() {

        Order order1 = new Order();
        order1.setCreationDate(LocalDateTime.now());
        Order order2 = new Order();
        order2.setStatus(Order.Status.ACTIVE);
        Set<Order> expectedOrders = new HashSet<>();
        expectedOrders.add(order1); expectedOrders.add(order2);

        User user = getUser();

        user.setOrders(expectedOrders);

        assertEquals(user.getOrders(), expectedOrders);
    }

    /** Comprobamos que se pueda introducir un shoppingCart a User **/
    @Test
    public void testUserByShoppingCart() {

        ShoppingCart expectedShoppingCart = getShoppingCart();
        User user = getUser();

        user.setShoppingCart(expectedShoppingCart);

        assertEquals(user.getShoppingCart(), expectedShoppingCart);
    }

    /**Comprobamos que se puedan introducir purchases en user **/
    @Test
    public void testUserByPurchases() {

        Purchase purchase1 = new Purchase(); Purchase purchase2 = new Purchase();
        purchase1.setQuantity(1); purchase2.setQuantity(2);
        Set<Purchase> expectedPurchases = new HashSet<>();
        expectedPurchases.add(purchase1); expectedPurchases.add(purchase2);

        User user = getUser();

        user.setPurchases(expectedPurchases);

        assertEquals(user.getPurchases(), expectedPurchases);
    }

    /**Comprobamos que se puedan introducir Replies al usuario **/
    @Test
    public void testUserByReplies() {

        Reply reply1 = new Reply(); Reply reply2 = new Reply();
        reply1.setContent("reply1"); reply2.setContent("reply2");
        Set<Reply> expectedReplies = new HashSet<>();
        expectedReplies.add(reply1); expectedReplies.add(reply2);

        User user = getUser();

        user.setReplies(expectedReplies);

        assertEquals(user.getReplies(), expectedReplies);

    }

    /**Comprobamos que se puedan introducir Topics al usuario **/
    @Test
    public void testUserByTopics() {

        Topic topic1 = new Topic(); Topic topic2 = new Topic();
        topic1.setContent("content1"); topic2.setContent("content2");
        Set<Topic> expectedTopics = new HashSet<>();
        expectedTopics.add(topic1); expectedTopics.add(topic2);

        User user = getUser();

        user.setTopics(expectedTopics);

        assertEquals(user.getTopics(), expectedTopics);

    }

    /**Comprobamos que se puedan introducir stats al usuario **/
    @Test
    public void testUserByStats() {

        Stats stats1 = new Stats(); Stats stats2 = new Stats();
        stats1.setStatName("stats1"); stats2.setStatName("stats2");
        Set<Stats> expectedStats = new HashSet<>();
        expectedStats.add(stats1); expectedStats.add(stats2);

        User user = getUser();

        user.setStats(expectedStats);

        assertEquals(user.getStats(), expectedStats);

    }

}








