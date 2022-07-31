import java.util.UUID;

public class Program {

    public static void main(String[] args) {
       
        TransactionService trService = new TransactionService();

        trService.addUser(new User("Sub-Zero", 12315));
        trService.addUser(new User("Scorpion", 55846));
        trService.addUser(new User("Lu Kang", 73000));

        UserArrayList usArrLst = trService.getUserArrList();

        System.out.println("--------START-------");
        for (int i = 0; i < usArrLst.getUsersNum(); i++) {
            System.out.println(usArrLst.getUserbyIndex(i).getID() + " " + usArrLst.getUserbyIndex(i).getName() + " " + usArrLst.getUserbyIndex(i).getBalance());
        }

        System.out.println("--------make transaction 30000-------");
        trService.makeTransaction(1, 2, 30000);
        System.out.println("--------make transaction 10000-------");
        trService.makeTransaction(1, 2, 10000);
        System.out.println("--------make transaction 5000-------");
        trService.makeTransaction(2, 1, 5000);
        System.out.println("--------make transaction 17000-------");
        trService.makeTransaction(3, 2, 17000);

        System.out.println("--------Lists of users transactions-------");
        for (int i = 0; i < usArrLst.getUsersNum(); i++) {   
            System.out.println(usArrLst.getUserbyIndex(i).getID() + " " + usArrLst.getUserbyIndex(i).getName() + " " + usArrLst.getUserbyIndex(i).getBalance());
            usArrLst.getUserbyIndex(i).getTransactionList().printTrList();
        }

        System.out.println("--------Remove one transaction-------");
        UUID trId1 = usArrLst.getUserbyID(1).getTransactionList().getFirst().getTransaction().getID();
        int usrId1 = 1;
        trService.removeUserTransaction(trId1, usrId1);

        System.out.println("--------Remove one transaction-------");
        UUID trId2 = usArrLst.getUserbyID(2).getTransactionList().getFirst().getNext().getTransaction().getID();
        int usrId2 = 2;
        trService.removeUserTransaction(trId2, usrId2);

        System.out.println("--------Lists of users transactions-------");
        for (int i = 0; i < usArrLst.getUsersNum(); i++) {   
            System.out.println(usArrLst.getUserbyIndex(i).getID() + " " + usArrLst.getUserbyIndex(i).getName() + " " + usArrLst.getUserbyIndex(i).getBalance());
            usArrLst.getUserbyIndex(i).getTransactionList().printTrList();
        }
        System.out.println("--------Arr of unpared transactions -------");
        Transaction[] unpared = trService.getArrOfUnparedTr();
        if (unpared != null) {
            for (int i = 0; unpared[i] != null; i++) {
                unpared[i].printTransaction();
            }
        }

        System.out.println("user 2 balance: " + trService.getUsrBalance(2));

        System.out.println("--------Get array of transactions of user1-------");
        Transaction [] usrTrArr = trService.getUserTrArr(1);
        int i = 0;
        for (Transaction t : usrTrArr) {
            t.printTransaction();
            i++;
        }

        System.out.println("--------make invalid transaction-------");
        trService.makeTransaction(3, 2, 17000);
    }
}
