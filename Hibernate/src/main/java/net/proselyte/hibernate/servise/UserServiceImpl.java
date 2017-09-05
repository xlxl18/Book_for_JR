package net.proselyte.hibernate.servise;

import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.dao.UserDAOHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("devHibernateService")
public class UserServiceImpl  implements  UserService {

    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private UserDAOHibernate userDAOHibernate;

    @Override
    public Integer addUser(String firstName, int age, byte isAdmin, Timestamp date) {
        return userDAOHibernate.addUser(firstName, age, isAdmin, date);
    }
    @Override
    public Integer updateUser(User user) {
        return userDAOHibernate.updateUser(user);
    }
    @Override
    public void removeUser(int id) {
        userDAOHibernate.removeUser(id);
    }
    @Override
    public List<User> getAllUsers(String userName) {
        return userDAOHibernate.getAllUsers(userName);
    }
    @Override
    public User getUser(int id){
        return userDAOHibernate.getUser(id);
    }
    @Override
    public List<User> listUsersReturnFROM(int start, int maxRows, String searchParameter){
        return userDAOHibernate.listUsersReturnFROM(start,maxRows,searchParameter);
    }
    @Override
    public int getCountUsers(){
        return userDAOHibernate.getCountUsers();
    }


}