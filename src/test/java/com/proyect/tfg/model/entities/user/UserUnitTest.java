package com.proyect.tfg.model.entities.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para verificar que la clase Usuario funciona como se esperaba. Probando siempre la mínima cantidad de código posible,
 * existiendo un único assert por test.
 *
 * - Nivel de Prueba: Unidad.
 *
 * - Categoría: Pruebas funcionales dinámica de caja negra negativa positivas.
 *
 *  - Datos Elegidos:
 *      - Datos por defecto que debería tener un usuario en la mayoria de su estado al ser creado.
 */
@SpringBootTest
public class UserUnitTest {

    private final Long defaultId = Long.valueOf(0);
    private final String defaultUserName = "userName";
    private final String defaultPassWord = "passWord";
    private final String defaultEmail = "email";
    private final User.WebRole defaultWebRole = User.WebRole.ADMIN;
    private final Long defaultCoins = Long.valueOf(0);
    private final Long defaultPremiumCoins = Long.valueOf(0);
    private final BigDecimal defaultDonatedMoney = BigDecimal.ZERO;
    private final LocalDateTime defaultRegisteredDate = LocalDateTime.now();
    private final LocalDateTime defaultLastTimeOnline = LocalDateTime.now();
    private final int defaultReputation = 0;
    private final int defaultVipRole = 0;
    private final Long defaultRank = Long.valueOf(0);
    private final String defaultLink = "link";
    private final boolean defaultVerified = false;

    private User getUser() {return new User();}

    /** Comprobamos que se pueda inicializar el id **/
    @Test
    public void testByUserId () {

        User u = getUser();
        u.setId(defaultId);

        assertEquals(u.getId(), defaultId);

    }

    /** Comprobamos que se pueda inicializar el nombre **/
    @Test
    public void testByUserName() {

        User u = getUser();
        u.setUserName(defaultUserName);

        assertEquals(u.getUserName(), defaultUserName);
    }

    /** Comprobamos que se pueda inicializar la contraseña **/
    @Test
    public void testByPassWord() {

        User u = getUser();
        u.setPassWord(defaultPassWord);

        assertEquals(u.getPassWord(), defaultPassWord);
    }

    /** Comprobamos que se pueda inicializar el email **/
    @Test
    public void testByEmail() {

        User u = getUser();
        u.setEmail(defaultEmail);

        assertEquals(u.getEmail(), defaultEmail);
    }

    /** Comprobamos que se pueda inicializar el rol Web **/
    @Test
    public void testByWebRole() {

        User u = getUser();
        u.setWebRole(defaultWebRole);

        assertEquals(u.getWebRole(), defaultWebRole);
    }

    /** Comprobamos que se pueda inicializar coins **/
    @Test
    public void testByCoins() {

        User u = getUser();
        u.setCoins(defaultCoins);

        assertEquals(u.getCoins(), defaultCoins);
    }

    /** Comprobamos que se pueda inicializar las monedas premium **/
    @Test
    public void testByPremiumCoins() {

        User u = getUser();
        u.setPremiumCoins(defaultPremiumCoins);

        assertEquals(u.getPremiumCoins(), defaultPremiumCoins);
    }

    /** Comprobamos que se pueda inicializar el dinero donado **/
    @Test
    public void testByDonatedMoney() {

        User u = getUser();
        u.setDonatedMoney(defaultDonatedMoney);

        assertEquals(u.getDonatedMoney(), defaultDonatedMoney);
    }

    /** Comprobamos que se pueda inicializar la fecha de registro **/
    @Test
    public void testByRegisteredDate() {

        User u = getUser();
        u.setRegisteredDate(defaultRegisteredDate);

        assertEquals(u.getRegisteredDate(), defaultRegisteredDate);
    }

    /** Comprobamos que se pueda inicializar la fecha del último logeo **/
    @Test
    public void testByLastRegisteredDate() {

        User u = getUser();
        u.setLastTimeOnline(defaultLastTimeOnline);

        assertEquals(u.getLastTimeOnline(), defaultLastTimeOnline);
    }

    /** Comprobamos que se pueda inicializar la reputación del usuario **/
    @Test
    public void testByReputation() {

        User u = getUser();
        u.setReputation(defaultReputation);

        assertEquals(u.getReputation(), defaultReputation);
    }

    /** Comprobamos que se pueda inicializar el nivel vip del usuario **/
    @Test
    public void testByUserVipLvl() {

        User u = getUser();
        u.setVipRole(defaultVipRole);

        assertEquals(u.getVipRole(), defaultVipRole);
    }

    /** Comprobamos que se pueda inicializar el ranking del usuario **/
    @Test
    public void testByUserRank() {

        User u = getUser();
        u.setRank(defaultRank);

        assertEquals(u.getRank(), defaultRank);
    }

    /** Comprobamos que se pueda inicializar el link del usuario **/
    @Test
    public void testByUserLink() {

        User u = getUser();
        u.setLink(defaultLink);

        assertEquals(u.getLink(), defaultLink);
    }

    /** Comprobamos que se pueda inicializar el verified del usuario **/
    @Test
    public void testByUserVerified() {

        User u = getUser();
        u.setVerified(defaultVerified);

        assertEquals(u.isVerified(), defaultVerified);
    }

    /**Comprobamos que el constructor con argumentos lo inicializa de forma correcta **/
    @Test
    public void testByUserArgsConstructor() {

        User user = new User(defaultUserName, defaultPassWord, defaultEmail, defaultWebRole,
                defaultCoins, defaultPremiumCoins, defaultDonatedMoney, defaultRegisteredDate, defaultLastTimeOnline, defaultReputation,
                defaultVipRole, defaultRank, defaultLink, defaultVerified);

        assertTrue((user.getUserName() == defaultUserName) && (user.getPassWord() == defaultPassWord) &&
                (user.getEmail() == defaultEmail) && (user.getWebRole() == defaultWebRole) &&
                (user.getCoins() == defaultCoins) && (user.getPremiumCoins() == defaultPremiumCoins) &&
                (user.getDonatedMoney() == defaultDonatedMoney) && (user.getRegisteredDate() == defaultRegisteredDate) &&
                (user.getLastTimeOnline() == defaultLastTimeOnline) && (user.getReputation() == defaultReputation) &&
                (user.getVipRole() == defaultVipRole) && (user.getRank() == defaultRank) &&
                (user.getLink() == defaultLink) && (user.isVerified() == defaultVerified));
    }
}
