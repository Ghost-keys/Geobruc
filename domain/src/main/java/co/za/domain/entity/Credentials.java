package co.za.domain.entity;

public record Credentials(
        String email,
        String password) {
    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }
}
