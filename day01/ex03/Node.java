public class Node {

    private Transaction transaction;
    private Node next;
    private Node prev;

    public Node(Transaction transaction, Node next, Node prev) {

        this.transaction = transaction;
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
}