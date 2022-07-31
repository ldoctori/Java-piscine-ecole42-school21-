public class Node {

    private Transaction transaction;
    private Transaction trDebit;
    private Transaction trCredit;
    private Node next;
    private Node prev;

    public Node(Transaction transaction, Node next, Node prev) {

        this.transaction = transaction;
        trDebit = null;
        trCredit = null;
        this.next = next;
        this.prev = prev;
    }

    public Node(Transaction trDebit, Transaction trCredit, Node next, Node prev) {

        this.transaction = null;
        setDebit(trDebit);
        setCredit(trCredit);
        this.next = next;
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Transaction getDebit() {
        return this.trDebit;
    }

    public Transaction getCredit() {
        return this.trCredit;
    }

    public void setDebit(Transaction trDebit) {
        this.trDebit = trDebit;
    }

    public void setCredit(Transaction trCredit) {
        this.trCredit = trCredit;
    }
}