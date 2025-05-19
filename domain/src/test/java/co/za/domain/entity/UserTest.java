package co.za.domain.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User defaultUser;
    private final String defaultUserId = "1";
    private final String defaultEmail = "test@user.com";
    private final String defaultPassword = "password";

    @Before
    public void setUp() {
        // Initialize a reusable User instance before each test
        defaultUser = new User(defaultUserId, defaultEmail, defaultPassword);
    }

    //--------------------------------------------------
    // Tests using the @Before-initialized defaultUser
    //--------------------------------------------------
    @Test
    public void equals_SameInstance_ReturnsTrue() {
        assertTrue(defaultUser.equals(defaultUser)); // Reflexivity
    }

    @Test
    public void equals_NullComparison_ReturnsFalse() {
        assertFalse(defaultUser.equals(null));
    }

    @Test
    public void equals_DifferentClass_ReturnsFalse() {
        Object otherObject = new Object();
        assertFalse(defaultUser.equals(otherObject));
    }

    //--------------------------------------------------
    // Tests requiring specific/different User instances
    //--------------------------------------------------
    @Test
    public void getters_ReturnCorrectValues() {
        // Use a dedicated instance for this test
        User user = new User("123", "test@example.com", "securePassword123");
        assertEquals("123", user.userId());
        assertEquals("test@example.com", user.email());
        assertEquals("securePassword123", user.password());
    }

    @Test
    public void equals_SameUserId_ReturnsTrue() {
        User userSameId = new User(defaultUserId, "different@email.com", "differentPassword");
        assertTrue(defaultUser.equals(userSameId));
    }

    @Test
    public void equals_DifferentUserId_ReturnsFalse() {
        User userDifferentId = new User("2", defaultEmail, defaultPassword);
        assertFalse(defaultUser.equals(userDifferentId));
    }

    @Test
    public void hashCode_SameUserId_ConsistentHash() {
        User userSameId = new User(defaultUserId, "another@email.com", "anotherPass");
        assertEquals(defaultUser.hashCode(), userSameId.hashCode());
    }

    @Test
    public void hashCode_DifferentUserId_DifferentHash() {
        User userDifferentId = new User("2", defaultEmail, defaultPassword);
        assertNotEquals(defaultUser.hashCode(), userDifferentId.hashCode());
    }
}