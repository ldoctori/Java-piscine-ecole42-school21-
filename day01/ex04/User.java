public class User {

    private int Identifier;
    private String Name;
    private int Balance;
    private TransactionLinkedList transactions;

    public User(String name, int balance) {

        setBalance(balance);
        setName(name);
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        setTransactionList();
    }

    private void setTransactionList() {
        this.transactions = new TransactionLinkedList();
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

    public void setID(int id) {
        this.Identifier = id;
    }

    public int getBalance() {
        return this.Balance;
    }

    public String getName() {
        return this.Name;
    }

    public int getID() {
        return this.Identifier;
    }

    public TransactionLinkedList getTransactionList() {
        return this.transactions;
    }
}