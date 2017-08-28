package net.proselyte.hibernate.servise;

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
    public Integer addDeveloper(String firstName, int age, String specialty, int experience) {
        return userDAOHibernate.addDeveloper(firstName, age, specialty, experience);
    }

    public Integer updateDeveloper(User user) {
        return userDAOHibernate.updateDeveloper(user);
    }

    @Override
    public void removeDeveloper(int developerId) {
        userDAOHibernate.removeDeveloper(developerId);
    }

    @Override
    public void listDevelopers() {

    }

    @Override
    public void updateDeveloper(int developerId, int experience) {

    }

    @Override
    public List<User> listDevelopersReturn() {
        return userDAOHibernate.listDevelopersReturn();
    }

    @Override
    public List<User> getAllUsers(String userName) {
        return userDAOHibernate.getAllUsers(userName);
    }
    public User getUser(int id){
        return userDAOHibernate.getUser(id);
    }

}