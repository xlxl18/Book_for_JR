package net.proselyte.hibernate.dao;


import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserDAOHibernate {

     Integer addUser(String name, int age, byte isAdmin, int date);
     Integer updateUser(User user);
     void removeUser(int id);
     List<User> listUsersReturn();
     List<User> getAllUsers(String nameOfUser);
     User getUser(int id);
     List<User> listUsersReturnFROM(int start, int maxRows);
     int  getCountUsers();
}
