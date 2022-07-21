package com.proyect.tfg.model.entities.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests para verificar que la clase stats del user funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una estadística de user en la mayoria de su estado al ser creado.
 */

@SpringBootTest
public class StatsUnitTest {

    private final String defaultStatName = "Agilidad";
    private final BigDecimal defaultStatValue = BigDecimal.valueOf(1.2);

    private Stats getStats() {return new Stats();}

    /** Comprobamos que se pueda inicializar el nombre de la stat **/
    @Test
    public void testStatsByName() {

        Stats stats = getStats();
        stats.setStatName(defaultStatName);

        assertEquals(stats.getStatName(), defaultStatName);
    }

    /** Comprobamos que se pueda inicializar el valor de la stat **/
    @Test
    public void testStatsByValue() {

        Stats stats = getStats();
        stats.setStatValue(defaultStatValue);

        assertEquals(stats.getStatValue(), defaultStatValue);
    }
}
