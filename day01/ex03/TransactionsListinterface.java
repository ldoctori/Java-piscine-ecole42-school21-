import java.util.UUID;

public interface TransactionsListinterface {
    
    public void addTransaction(Transaction transaction);
    public void removeByID(UUID id);
    public Transaction[] toArray();
}