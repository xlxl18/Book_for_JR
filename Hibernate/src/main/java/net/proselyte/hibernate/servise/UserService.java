package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserService {

    Integer addUser(String firstName, int age, String specialty, int experience);
    Integer updateUser(User user);
    void removeUser(int developerId);
    User getUser(int id);
    List<User> listUsersReturn();
    List<User> getAllUsers(String userName);

}
