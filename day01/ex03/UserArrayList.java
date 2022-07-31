public class UserArrayList implements UserList {

    private User[] usarr;
    private final int DEF_SIZE = 10;
    private int size;
    private int usersNum;

    public UserArrayList() {

        usarr = new User[DEF_SIZE];
        size = DEF_SIZE;
        usersNum = 0;
        
    }

    public void addUser(User newUser) {

        int i = 0;

        while (i < usersNum) {
            i++;
        }
        if (i < this.size) {
            usarr[i] = newUser;
        } else {
            increaseSize();
            usarr[i] = newUser;
        }
        this.usersNum = i + 1;
    }

    private void increaseSize() {

        User[] tmp;
        int oldsize = this.size;
        int i = 0;

        this.size = oldsize + (oldsize / 2);
        tmp = new User[this.size];
        while (i < oldsize) {
            tmp[i] = this.usarr[i];
            i++;
        }
        this.usarr = tmp;
    }

    public User getUserbyIndex (int index) {
        return this.usarr[index];
    }

    public User getUserbyID (int id) throws UserNotFoundException {
        for (int i = 0; i < usersNum; i++)
        {
            if (usarr[i].getIdentifier() == id)
                return usarr[i];
        }
        throw new UserNotFoundException();
    }

    public int getUsersNum() {
        return this.usersNum;
    }
    public int getSize() {
        return this.size;
    }
}