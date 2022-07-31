public class User {

    private int Identifier;
    private String Name;
    private int Balance;
    private TransactionLinkedList transactions;

    public User(String name, int balance) {

        setBalance(balance);
        setName(name);
        this.Identifier = UserIdsGenerator.getInstance().generateId();
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            this.Balance = 0;
        } else {
            this.Balance = balance;
        }
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

    public void setTransactionList(TransactionLinkedList transactions) {
        this.transactions = transactions;
    }

    public TransactionLinkedList getTransactionList() {
        return this.transactions;
    }

}