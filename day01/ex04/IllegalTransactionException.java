public class IllegalTransactionException extends RuntimeException {

    public IllegalTransactionException() {
        super ("Insufficient balance!");
    }
}