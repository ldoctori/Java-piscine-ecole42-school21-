public class Program {

    public static void main(String[] args) {
       
        String usersNames1[] = {"Scorpion", "Sub-zero", "Erron Black",
                                "Baraka", "Cassie Cage", "Jade", "Jax Briggs", 
                                "Johnny Cage", "Kano", "Kitana"};
        String userNames2 = "Sonya Blade";
        String userNames3[] = {"Shao Kahn", "Skarlet", "Kung Lao", "Liu Kang", "Shang Zung"};
    
        System.out.println("-----Create UserArrayList-----");
        UserArrayList users = new UserArrayList();
        int size = users.getSize();
        int i = 0;
        while (i < size && usersNames1[i] != null) {
            users.addUser(new User(usersNames1[i], i * 10 + i));
            i++;
        }
        for (i = 0; i < size; i++) {
            System.out.println("id: " + users.getUserbyIndex(i).getIdentifier() + 
                                ", name: " + users.getUserbyIndex(i).getName() + 
                                ", balance: " + users.getUserbyIndex(i).getBalance());
        }
        System.out.println("Array size = " + users.getSize());

        System.out.println("-----Trying to add an excess user-----");
        users.addUser(new User(userNames2, 123456));
        System.out.println("id: " + users.getUserbyIndex(i).getIdentifier() + 
                                ", name: " + users.getUserbyIndex(i).getName() + 
                                ", balance: " + users.getUserbyIndex(i).getBalance());
        System.out.println("Array size = " + users.getSize());


        System.out.println("-----Trying to add more excess users-----");
        for (i = 0; i < userNames3.length; i++) {
            users.addUser(new User(userNames3[i], i * 10 + i));
        }
        for (i = 0; i < users.getUsersNum(); i++) {
            System.out.println("id: " + users.getUserbyIndex(i).getIdentifier() + 
                                ", name: " + users.getUserbyIndex(i).getName() + 
                                ", balance: " + users.getUserbyIndex(i).getBalance());
        }
        System.out.println("Array size = " + users.getSize());

        System.out.println("-----Trying to get user by ID-----");
        System.out.println("id: " + users.getUserbyID(16).getIdentifier() + 
                                ", name: " + users.getUserbyID(16).getName() + 
                                ", balance: " + users.getUserbyID(16).getBalance());

        System.out.println("-----Trying to get not existing user by ID-----");
        users.getUserbyID(17);
    }
}
