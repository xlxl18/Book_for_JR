package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserService {

    Integer addUser(String name, int age, byte isAdmin, int date);
    Integer updateUser(User user);
    void removeUser(int user);
    User getUser(int id);
    List<User> listUsersReturn();
    List<User> getAllUsers(String name);
    List<User> listUsersReturnFROM(int start, int maxRows);
    int getCountUsers();

}
