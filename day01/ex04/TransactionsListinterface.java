import java.util.UUID;

public interface TransactionsListinterface
{
    public void addTransaction(Transaction transaction);
    public Category removeByID(UUID id);
    public Transaction[] toArray();
}