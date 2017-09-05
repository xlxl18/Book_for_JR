package net.proselyte.hibernate.dao;


import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.User;

import java.util.List;

public interface UserDAOHibernate {

     Integer addUser(String name, int age, byte isAdmin, Timestamp date);
     Integer updateUser(User user);
     List<User> getAllUsers(String nameOfUser);
     List<User> listUsersReturnFROM(int start, int maxRows, String searchParameter);
     User getUser(int id);
     int getCountUsers();
     void removeUser(int id);

}
