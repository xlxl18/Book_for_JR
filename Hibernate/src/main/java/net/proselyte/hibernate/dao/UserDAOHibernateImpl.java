package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAOHibernate {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Integer addUser(String user, int age, byte isAdmin, int date) {
        System.out.println("Попытка добавления пользователя в базу = " + user);
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        User developer = new User(user, age, isAdmin, date);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }
    @Override
    public Integer updateUser(User user) {
        System.out.println("Попытка добавления пользователя в базу = " + user.getName());
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;
        Integer developerId = null;
        transaction = session.beginTransaction();
        session.update(user);
        //session.save(user);

/*
        if(user.getId() == 0){ // if user id is 0 then creating user other updating user
            session.save(user);
        } else {
            session.delete(user);
            session.save(user);
        }

*/
        transaction.commit();
        session.close();
        return developerId;
    }
    @Override
    public void removeUser(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User developer = (User) session.get(User.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
    @Override
    public List<User> listUsersReturn() {
        List<User> users;
        //Session session = getCurrentSession();
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        users = session.createQuery("FROM User").list();
        session.close();
        Collections.sort(users);
        return users;
    }
    @Override
    public List<User> getAllUsers(String nameOfUser){
        List<User> allUsers;
        List<User> users = new ArrayList<User>();
        //Session session = getCurrentSession();
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        allUsers = session.createQuery("FROM User").list();
        session.close();
        for (User us: allUsers){
            if (nameOfUser.equals(us.getName())){
                users.add(us);}
        }
        Collections.sort(users);
        return users;
    }
    @Override
    public User getUser(int id){
        List<User> allUsers;
        User users = null;
        //Session session = getCurrentSession();
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        allUsers = session.createQuery("FROM User").list();
        session.close();
        for (User us: allUsers){
            if (id == us.getId()) {
                users = us;}
        }
        return users;

    }
    @Override
    public List<User> listUsersReturnFROM(int start, int maxRows) {
        List<User> users;
        //Session session = getCurrentSession();
        Session session = getSessionFactory().openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        // SQL: SELECT * FROM User LIMIT start, maxRows;
        Query q = session.createQuery("FROM User");
        q.setFirstResult(start);
        q.setMaxResults(maxRows);
        users = q.list();

        session.close();
        return users;
    }


}
