public class Printer {
    
    private boolean buff;

	public Printer() {
		this.buff = false;
	}

	public synchronized void printMessage(String message, Type type) throws InterruptedException{
		if (type == Type.CONSUMER) {
			while (buff == false) {
				this.wait();
			}
			buff = false;
		} else {
			while (buff == true) {
				this.wait();
			}
			buff = true;
		}
		System.out.println(message);
		this.notify();
	}
}
