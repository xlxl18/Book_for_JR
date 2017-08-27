package net.proselyte.hibernate.dao;


import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface DeveloperDAOHibernate {

     Integer addDeveloper(String user, int age, String isAdmin, int date);
     Integer addDeveloper(User user);
     void removeDeveloper(int developerId);
     boolean findUser(String user);
     void updateDeveloper(int developerId, int experience);
     List<User> listDevelopersReturn();
     List<User> getAllUsers(String userName);
}
