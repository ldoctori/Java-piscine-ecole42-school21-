import java.util.UUID;

enum Category {
    debit,
    credit
}

public class Transaction {
    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Category Category;
    private int Amount;

    public Transaction(User recipient, User sender, Category category, int amount) {
        this.Recipient = recipient;
        this.Sender = sender;
        this.Category = category;
        setAmount(amount);
        this.Identifier = UUID.randomUUID();
    }

    public void setAmount(int amount) {
        if ((this.Category == Category.credit) && (amount > 0)) {
            System.out.println("Credit should be negative! Amount is set to zero!");
            this.Amount = 0;
        } else if ((this.Category == Category.debit) && (amount < 0)) {
            System.out.println("Debit should be positive! Amount is set to zero!");
            this.Amount = 0;
        } else
            this.Amount = amount;
    }

    public int getAmount() {
        return this.Amount;
    }
    
    public UUID getID() {
        return this.Identifier;
    }

    public User getRecipient() {
        return this.Recipient;
    }

    public User getSender() {
        return this.Sender;
    }

    public Category getCategory() {
        return this.Category;
    }
}
