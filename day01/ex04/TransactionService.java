import java.util.UUID;

public class TransactionService {

    private UserArrayList userArrList;
    private TransactionLinkedList transactionPares;
    
    public TransactionService() {

        userArrList = new UserArrayList();
        transactionPares = new TransactionLinkedList();
    }
    
    public void addUser(User usr) {
        userArrList.addUser(usr);
    }

    public int getUsrBalance(int id) {
        return userArrList.getUserbyID(id).getBalance();
    }

    public void makeTransaction(int retId, int sendId, int amount) throws IllegalTransactionException {

        User ret = userArrList.getUserbyID(retId);
        User send = userArrList.getUserbyID(sendId);

        int retBalance = ret.getBalance();
        int sendBalance = send.getBalance();

        if (sendBalance < amount) {
            throw new IllegalTransactionException();
        }
        Transaction retTransaction = new Transaction(ret, send, Category.debit, amount);
        ret.getTransactionList().addTransaction(retTransaction);

        Transaction sendTransaction = new Transaction(send, ret, Category.credit, amount * (-1));
        sendTransaction.setID(retTransaction.getID());
        send.getTransactionList().addTransaction(sendTransaction);

        transactionPares.addTransactionPare(retTransaction, sendTransaction);

        ret.setBalance(retBalance + amount);
        send.setBalance(sendBalance - amount); 
    }

    public void removeUserTransaction(UUID trId, int usrId) {

        Category cat = userArrList.getUserbyID(usrId).getTransactionList().removeByID(trId);
        Node tmp = transactionPares.getFirst();
        Transaction trD, trC;

        while (tmp != null) {
            trD = tmp.getDebit();
            trC = tmp.getCredit();
            if ((trD != null) && (trD.getID() == trId) && (trD.getCategory() == cat)) {
                tmp.setDebit(null);
            } else if ((trC != null) && (trC.getID() == trId) && (trC.getCategory() == cat)) {
                tmp.setCredit(null);
            }
            tmp = tmp.getNext();
        }

    }

    public Transaction[] getArrOfUnparedTr() {

        Node tmp1 = transactionPares.getFirst();
        Node tmp2 = tmp1;
        int size = 0;
        int i = 0;
        while (tmp1 != null) {
            if ((tmp1.getDebit() == null) && (tmp1.getCredit() == null)) {
                tmp1 = tmp1.getNext();
                continue ;
            }
            if ((tmp1.getDebit() == null) || (tmp1.getCredit() == null)) {
                size++;
            }
            tmp1 = tmp1.getNext();
        }
        if (size <= 0) {
            return null;
        }
        Transaction[] trUnparedArr = new Transaction[size + 1];
        while (tmp2 != null && i < size) {
            if (tmp2.getDebit() == null) {
                trUnparedArr[i] = tmp2.getCredit();
                i++;
            } else if (tmp2.getCredit() == null) {
                trUnparedArr[i] = tmp2.getDebit();
                i++;
            }
            tmp2 = tmp2.getNext();
        }
        trUnparedArr[i] = null;

        return trUnparedArr;

    }

    public Transaction[] getUserTrArr(int id) {
        return userArrList.getUserbyID(id).getTransactionList().toArray();
    }

    public UserArrayList getUserArrList() {
        return this.userArrList;
    }

    public TransactionLinkedList getTransactionPareList() {
        return this.transactionPares;
    }
}