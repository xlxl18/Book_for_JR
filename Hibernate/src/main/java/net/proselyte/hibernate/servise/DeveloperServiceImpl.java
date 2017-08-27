package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.dao.DeveloperDAOHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("devHibernateService")
public class DeveloperServiceImpl  implements  DeveloperService {

    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private DeveloperDAOHibernate developerDAOHibernate;

    @Override
    public Integer addDeveloper(String firstName, int age, String specialty, int experience) {
        return developerDAOHibernate.addDeveloper(firstName, age, specialty, experience);
    }

    public Integer addDeveloper(User user) {
        return developerDAOHibernate.addDeveloper(user);
    }

    @Override
    public void removeDeveloper(int developerId) {
        developerDAOHibernate.removeDeveloper(developerId);
    }

    @Override
    public void listDevelopers() {

    }

    @Override
    public void updateDeveloper(int developerId, int experience) {

    }

    @Override
    public List<User> listDevelopersReturn() {
        return developerDAOHibernate.listDevelopersReturn();
    }

    @Override
    public List<User> getAllUsers(String userName) {
        return developerDAOHibernate.getAllUsers(userName);
    }

}