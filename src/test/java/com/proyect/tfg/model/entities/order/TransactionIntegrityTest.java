package com.proyect.tfg.model.entities.order;


import com.proyect.tfg.model.entities.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests para verificar que la Transaction Order funciona como se espera.
 *
 * - Nivel de Prueba: Integridad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto cualesquiera que deberían tener las clases que interactuan con Transaction.
 */

/** Error Encontrado(y solucionado): En el constructor con argumentos faltaba el Order **/
@SpringBootTest
public class TransactionIntegrityTest {

    private final LocalDateTime defaultDateOfOrder = LocalDateTime.now();
    private final LocalDateTime defaultDateOfTransaction = LocalDateTime.now().plusHours(1);
    private final int defaultTransactionValue = 0;
    private final int defaultTransactionAmount = 0;

    private Order getOrder() {
        Order order = new Order();
        order.setCreationDate(defaultDateOfOrder);
        return order;
    }

    private Transaction getTransaction() {return new Transaction();}

    private Transaction getTransactionByArgsConstructor(Order order) {return new Transaction(order,
            defaultDateOfTransaction, defaultTransactionValue, defaultTransactionAmount);}

    /** Comprobaremos que la order metida dentro del estado de Transaction corresponde con la esperada **/
    @Test
    public void testTransactionByOrder() {

        Order expectedOrder = getOrder();
        Transaction transaction = getTransaction();

        transaction.setOrder(expectedOrder);

        assertEquals(transaction.getOrder(), expectedOrder);
    }

    /** Comprobaremos que la order metida dentro del estado de Transaction usando el constructor es la introducida
     * y también los demás campos **/
    @Test
    public void testTransactionByArgsConstructor() {

        Order expectedOrder = getOrder();
        Transaction transaction = getTransactionByArgsConstructor(expectedOrder);

        assertTrue((transaction.getOrder().equals(expectedOrder) &&
                (transaction.getDateOfTransaction() == defaultDateOfTransaction) &&
                (transaction.getTransactionValue() == defaultTransactionValue) &&
                (transaction.getTransactionAmount() == defaultTransactionAmount)));
    }


}
