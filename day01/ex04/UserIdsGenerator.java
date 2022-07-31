public class UserIdsGenerator {

    private static UserIdsGenerator instance;
    private int id;
    private UserIdsGenerator() {
        this.id = 0;
    }

    public static UserIdsGenerator getInstance() {

        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        
        this.id += 1;
        return this.id;
    }

}