public interface UserList {
    
    public void addUser(User newUser);
    public User getUserbyID(int id);
    public User getUserbyIndex(int index);
    public int getUsersNum();
    public int getSize();
}