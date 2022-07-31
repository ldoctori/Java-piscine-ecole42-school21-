package school21.spring.service.models;

public class User {

    private long Identifier;
    private String Email;

    public User(long Identifier, String Email) {

        this.Identifier = Identifier;
        this.Email = Email;
    }

    public long getIdentifier() {
        return this.Identifier;
    }
    public String getEmail() {
        return this.Email;
    }
}
