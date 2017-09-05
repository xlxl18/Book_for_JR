package net.proselyte.hibernate.servise;

import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserService {

    Integer addUser(String name, int age, byte isAdmin, Timestamp date);
    Integer updateUser(User user);
    void removeUser(int user);
    User getUser(int id);
    List<User> getAllUsers(String name);
    List<User> listUsersReturnFROM(int start, int maxRows, String searchParameter);
    int getCountUsers();


}
