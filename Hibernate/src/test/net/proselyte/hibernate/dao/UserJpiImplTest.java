package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.User;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

public class UserJpiImplTest extends EntityDaoImplTest {

    public EntityManager em;// менеджер сущностей

    //@Qualifier("getUserJpiImpl")
    @Autowired
    UserDAOHibernate userDAOHibernate;

    @Test //готов
    public void addUser(String user, int age, byte isAdmin, Timestamp date) {
        User us = new User();
        us.setName(user);
        us.setAge(age);
        us.setIsAdmin(isAdmin);
        us.setDate(date);
        em.persist(us);
    }

    @Test //готов
    public Integer updateUser(User user) {
        return em.merge(user).getId();
    }
    @Test // готов
    public void removeUser(int id) {
        em.remove(getUser(id));
    }

    @Test // готов
    public List<User> getAllUsers(String nameOfUser){
        return em.createQuery("FROM User u").getResultList();
    }
    @Test // готов
    public User getUser(int id){
        return em.find(User.class, id);
    }
    //готов
    public List<User> listUsersReturnFROM(int start, int maxRows, String name) {
        TypedQuery<User> q = em.createNamedQuery("User.getAll", User.class);
        if (null != name && !name.equals("")) {
            q = em.createNamedQuery("User.getFrom", User.class);
            q.setParameter("name", name );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    @Test // готов
    public int getCountUsers(){
        return em.createNamedQuery("User.getAll", User.class).getResultList().size();
    }


    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
        return dataSet;
    }
}
