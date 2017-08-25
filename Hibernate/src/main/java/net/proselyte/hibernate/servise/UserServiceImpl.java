package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.dao.UserDAOHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("devHibernateService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private UserDAOHibernate userDAOHibernate;

    @Override
    public Integer addUser(String name, int age, boolean isAdmin, Date createdDate) {
        return userDAOHibernate.addUser(name, age, isAdmin, createdDate);
    }

    @Override
    public void removeUser(int id) {

    }

    @Override
    public boolean findUser(String name) {
       return userDAOHibernate.findUser(name);
    }

    @Override
    public void updateUser(int developerId, int experience) {

    }

    @Override
    public List<User> listUserReturn() {
        return userDAOHibernate.listUserReturn();
    }
}
