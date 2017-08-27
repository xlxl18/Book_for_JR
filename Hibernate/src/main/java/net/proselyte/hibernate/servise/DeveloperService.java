package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface DeveloperService {

    Integer addDeveloper(String firstName, int age, String specialty, int experience);
    Integer addDeveloper(User user);
    void removeDeveloper(int developerId);
    void listDevelopers();
    void updateDeveloper(int developerId, int experience);
    User getUser(int id);
    List<User> listDevelopersReturn();
    List<User> getAllUsers(String userName);

}
