package com.proyect.tfg.model.entities.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la clase stats del user funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una estadística de user en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class StatsIntegrityTest {

    private final String defaultStatName = "Agilidad";
    private final BigDecimal defaultStatValue = BigDecimal.valueOf(1.2);

    private User getUser() {return new User("userName", "password", "email", User.WebRole.USER,
            Long.valueOf(0), Long.valueOf(0), BigDecimal.ZERO, LocalDateTime.now(), LocalDateTime.now(), 0,
            0, Long.valueOf(0), "link", true);}

    private Stats getStats() {return new Stats();}

    private Stats getStatsByArgsConstructor(User user) {return new Stats(user, defaultStatName, defaultStatValue);}

    /**Comprobamos que se pueda incorporar a la clase stats el user con el set**/
    @Test
    public void testStatsByUser() {

        User expectedUser = getUser();
        Stats stats = getStats();

        stats.setUser(expectedUser);

        assertEquals(stats.getUser(), expectedUser);
    }

    /**Comprobamos el correcto funcionamiento del constructor con todos sus campos **/
    @Test
    public void testStatsByArgsConstructor() {

        User expectedUser = getUser();
        Stats stats = getStatsByArgsConstructor(expectedUser);

        assertTrue((stats.getUser().equals(expectedUser)) &&
                (stats.getStatName() == defaultStatName) &&
                (stats.getStatValue() == defaultStatValue));
    }

}













