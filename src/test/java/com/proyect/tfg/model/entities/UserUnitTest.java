package com.proyect.tfg.model.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserUnitTest {

    @Test
    public void testByUserName() {

        User u = new User();
        u.setUserName("Default");

        assertEquals(u.getUserName(), "Default");
    }
}
