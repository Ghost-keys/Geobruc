package co.za.domain.entity;


/**
 * User entity representing a registered user in our application.
 * This is a pure Java class with no Android dependencies.
 */

public record User(
        String userId,
        String email,
        String password) {

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return userId.equals(user.userId);
    }
}
