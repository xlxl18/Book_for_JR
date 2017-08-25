package net.proselyte.hibernate.dao;



import net.proselyte.hibernate.annotations.User;

import java.util.Date;
import java.util.List;

public interface UserDAOHibernate {

     Integer addUser(String name, int age, boolean isAdmin, Date createdDate);
     void removeUser(int userId);
     boolean findUser(String name);
     void updateUser(int id, String name, int age, boolean isAdmin, Date createdDate);
     List<User> listUserReturn();
}
