package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    Integer addUser(String name, int age, boolean isAdmin, Date createdDate);
    void removeUser(int developerId);
    boolean findUser(String name);
    void updateUser(int developerId, int experience);
    List<User> listUserReturn();
}
