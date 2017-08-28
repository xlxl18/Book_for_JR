package net.proselyte.hibernate.dao;


import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserDAOHibernate {

     Integer addUser(String user, int age, String isAdmin, int date);
     Integer updateUser(User user);
     void removeUser(int developerId);
     List<User> listUsersReturn();
     List<User> getAllUsers(String userName);
     User getUser(int id);
}
