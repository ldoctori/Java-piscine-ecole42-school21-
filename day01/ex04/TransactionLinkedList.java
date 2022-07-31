import java.util.UUID;

class TransactionLinkedList implements TransactionsListinterface {

    private Node first;
    private Node last;
    private int size;

    public TransactionLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void addTransaction(Transaction transaction) {
        Node tmp;
        if (size == 0) {
            first = new Node(transaction, null, null);
            last = first;
        } else {
            tmp = last;
            last.setNext(new Node(transaction, null, null));
            last = last.getNext();
            last.setPrev(tmp);
        }
        size++;
    }

    public void addTransactionPare(Transaction trDebit, Transaction trCredit) {
        Node tmp;
        if (size == 0) {
            first = new Node(trDebit, trCredit, null, null);
            last = first;
        } else {
            tmp = last;
            last.setNext(new Node(trDebit, trCredit, null, null));
            last = last.getNext();
            last.setPrev(tmp);
        }
        size++;
    }

    public Category removeByID(UUID id) throws TransactionNotFoundException {

        Node tmp = first;
        Category cat;

        while (tmp != null) {
            if (tmp.getTransaction().getID().equals(id)) {
                Node tmpPrev = tmp.getPrev();
                Node tmpNext = tmp.getNext();
                if ((tmpPrev == null) && (tmpNext == null)) {
                    first = null;
                    last = null;
                } else if (tmpPrev == null) {
                    tmpNext.setPrev(null);
                    first = tmpNext;
                } else if (tmpNext == null) {
                    tmpPrev.setNext(null);
                    last = tmpPrev;
                } else {
                    tmpPrev.setNext(tmpNext);
                    tmpNext.setPrev(tmpPrev);
                }
                cat = tmp.getTransaction().getCategory();
                tmp.setNext(null);
                tmp.setPrev(null);
                tmp.setTransaction(null);
                size--;
                return cat;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    public Transaction[] toArray() {

        Transaction[] trArr = new Transaction[size];
        int i = 0;
        Node tmp = first;
        while (i < size) {
            trArr[i] = tmp.getTransaction();
            i++;
            tmp = tmp.getNext();
        }
        return trArr;
    }

    public void printTrList() {

        Node tmp = first;
        while (tmp != null) {
            tmp.getTransaction().printTransaction();
            tmp = tmp.getNext();
        }
    }

    public void printTrPareList() {

        Node tmp = first;
        while (tmp != null) {
            tmp.getDebit().printTransaction(); 
            tmp.getCredit().printTransaction();
            tmp = tmp.getNext();
        }
    }

    public int getSize() {
        return this.size;
    }

    public Node getFirst() {
        return this.first;
    }
}