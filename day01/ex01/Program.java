public class Program {

    public static void main(String[] args) {
       
        User usr1 = new User("John", 456464);
        User usr2 = new User("Mike", 789132);
        User usr3 = new User("Helga", 0);
    
        System.out.println("id: " + usr1.getIdentifier() + ", name: " + usr1.getName() + ", balance: " + usr1.getBalance());
        System.out.println("id: " + usr2.getIdentifier() + ", name: " + usr2.getName() + ", balance: " + usr2.getBalance());
        System.out.println("id: " + usr3.getIdentifier() + ", name: " + usr3.getName() + ", balance: " + usr3.getBalance());

    }
}
