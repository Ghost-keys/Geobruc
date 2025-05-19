package co.za.domain.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CredentialsTest {

    private Credentials userCredentials;

    @Before
    public void setUp() {
        userCredentials = new Credentials(
                "bonganialfred@gmail.com",
                "mySecurePassword"
        );
    }

    @Test
    public void credentials_return_correctDetails() {
        assertEquals("bonganialfred@gmail.com", userCredentials.email());
        assertEquals("mySecurePassword", userCredentials.password());
    }
}
