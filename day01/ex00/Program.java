public class Program {

    public static void main(String[] args) {
       
        User usr1 = new User(1, "John", 456464);
        User usr2 = new User(2, "Mike", 789132);
    
        System.out.println("id: " + usr1.getIdentifier() + ", name: " + usr1.getName() + ", balance: " + usr1.getBalance());
        System.out.println("id: " + usr2.getIdentifier() + ", name: " + usr2.getName() + ", balance: " + usr2.getBalance());

        System.out.println("--------Make transaction--------");
        Transaction tr1 = new Transaction(usr1, usr2, Category.debit, 3721);
        Transaction tr2 = new Transaction(usr2, usr1, Category.credit, -3721);
        System.out.println("ID: " + tr1.getID());
        System.out.println("Sender: " + tr1.getSender().getName() + ", Recipient: " +  tr1.getRecipient().getName());
        System.out.println("Category : " + tr1.getCategory() + ", Amount: " +  tr1.getAmount());
        System.out.println("ID: " + tr2.getID());
        System.out.println("Sender: " + tr2.getSender().getName() + ", Recipient: " +  tr2.getRecipient().getName());
        System.out.println("Category : " + tr2.getCategory() + ", Amount: " +  tr2.getAmount());


        System.out.println("--------Make invalid transaction--------");
        Transaction Invtr1 = new Transaction(usr1, usr2, Category.debit, -3721);
        Transaction Invtr2 = new Transaction(usr2, usr1, Category.credit, 3721);
        System.out.println("ID: " + Invtr1.getID());
        System.out.println("Sender: " + Invtr1.getSender().getName() + ", Recipient: " +  Invtr1.getRecipient().getName());
        System.out.println("Category : " + Invtr1.getCategory() + ", Amount: " +  Invtr1.getAmount());
        System.out.println("ID: " + Invtr2.getID());
        System.out.println("Sender: " + Invtr2.getSender().getName() + ", Recipient: " +  Invtr2.getRecipient().getName());
        System.out.println("Category : " + Invtr2.getCategory() + ", Amount: " +  Invtr2.getAmount());
    

    }
}
