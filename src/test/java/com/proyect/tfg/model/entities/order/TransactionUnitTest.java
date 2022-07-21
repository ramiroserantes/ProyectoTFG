package com.proyect.tfg.model.entities.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Transactions funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test. No es importante que pueda crear transactions con valor 0 o cantidad 0, debido a que eso se regu-
 * lará en el servicio.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener una transacción en la mayoria de su estado al ser creado.
 */

/**Error encontrado(y solucionado): Nombre de la propiedad setTransactionAmount incorrecto **/
@SpringBootTest
public class TransactionUnitTest {

    private final LocalDateTime defaultDateOfTransaction = LocalDateTime.now();
    private final int defaultTransactionValue = 0;
    private final int defaultTransactionAmount = 0;

    private Transaction getTransaction() {return new Transaction();}

    /** Comprobamos que se pueda inicializar la fecha de transacción **/
    @Test
    public void testByDateOfTransaction() {

        Transaction transaction =  getTransaction();
        transaction.setDateOfTransaction(defaultDateOfTransaction);

        assertEquals(transaction.getDateOfTransaction(), defaultDateOfTransaction);

    }

    /** Comprobamos que se pueda inicializar el valor de la transacción **/
    @Test
    public void testByTransactionValue() {

        Transaction transaction =  getTransaction();
        transaction.setTransactionValue(defaultTransactionValue);

        assertEquals(transaction.getTransactionValue(), defaultTransactionValue);

    }

    /** Comprobamos que se pueda inicializar el valor de la cantidad de la transacción **/
    @Test
    public void testByTransactionAmount() {

        Transaction transaction =  getTransaction();
        transaction.setTransactionAmount(defaultTransactionAmount);

        assertEquals(transaction.getTransactionAmount(), defaultTransactionAmount);

    }

}
