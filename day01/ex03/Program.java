import java.util.UUID;

public class Program {

    public static void main(String[] args) {
       
        User usr1 = new User("Sub-Zero", 12315);
        User usr2 = new User("Scorpion", 55846);
        User usr3 = new User("Lu Kang", 75135);

        usr1.setTransactionList(new TransactionLinkedList());
        usr2.setTransactionList(new TransactionLinkedList());
        usr3.setTransactionList(new TransactionLinkedList());
        
        usr1.getTransactionList().addTransaction(new Transaction(usr1, usr2, Category.debit, 5000));
        usr2.getTransactionList().addTransaction(new Transaction(usr2, usr1, Category.credit, -5000));
        usr2.getTransactionList().addTransaction(new Transaction(usr2, usr3, Category.debit, 1000));
        usr3.getTransactionList().addTransaction(new Transaction(usr3, usr2, Category.credit, -1000));
        
        usr1.getTransactionList().addTransaction(new Transaction(usr1, usr2, Category.debit, 378));
        usr2.getTransactionList().addTransaction(new Transaction(usr2, usr1, Category.credit, -378));

        System.out.println("------------USR1-----------");
        usr1.getTransactionList().printTrList();
        System.out.println("size: " + usr1.getTransactionList().getSize());
        
        System.out.println("------------USR2-----------");
        usr2.getTransactionList().printTrList();
        System.out.println("size: " + usr2.getTransactionList().getSize());

        System.out.println("------------USR3-----------");
        usr3.getTransactionList().printTrList();
        System.out.println("size: " + usr3.getTransactionList().getSize());

        System.out.println("------------TrList of usr2 to Array-----------");
        Transaction arr[] = usr2.getTransactionList().toArray();
        for (int i = 0; i < arr.length; i++)
            arr[i].printTransaction();

        System.out.println("------------Delete one transaction in TrList of usr2-----------");
        UUID id = usr2.getTransactionList().getFirst().getNext().getTransaction().getID();
        usr2.getTransactionList().removeByID(id);
        usr2.getTransactionList().printTrList();

        System.out.println("------------Trying to delete it again-----------");
        usr2.getTransactionList().removeByID(id);

    }
}
