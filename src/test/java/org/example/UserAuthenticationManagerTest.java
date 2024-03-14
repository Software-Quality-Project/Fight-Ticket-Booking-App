package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class UserAuthenticationManagerTest {

    private UserAuthenticationManager authenticationManager;

    @Before
    public void setUp() {
        authenticationManager = new UserAuthenticationManager();
    }

    @Test
    public void testAuthenticateUser() {
        // Test authenticating existing user with correct password
        assertTrue(authenticationManager.authenticateUser("Ronaldo", "Ronaldo34"));

        // Test authenticating existing user with incorrect password
        assertFalse(authenticationManager.authenticateUser("Ronaldo", "ronaldi43"));

        // Test authenticating non-existing user
        assertTrue(authenticationManager.authenticateUser("newUser", "newPassword"));

        // Test authenticating newly added user
        assertTrue(authenticationManager.authenticateUser("newUser", "newPassword"));
    }
}
