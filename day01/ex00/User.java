public class User {

    private int Identifier;
    private String Name;
    private int Balance;

    public User(int id, String name, int balance) {
        setIdentifier(id);
        setBalance(balance);
        setName(name);
    }

    public void setBalance(int balance) {
        if (balance < 0)
            this.Balance = 0;
        else
            this.Balance = balance;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setIdentifier(int id) {
        this.Identifier = id;
    }

    public int getBalance() {
        return this.Balance;
    }

    public String getName() {
        return this.Name;
    }

    public int getIdentifier() {
        return this.Identifier;
    }
}