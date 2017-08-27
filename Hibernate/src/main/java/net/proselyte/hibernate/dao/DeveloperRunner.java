package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

@Repository
public class DeveloperRunner implements DeveloperDAOHibernate {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Integer addDeveloper(String user, int age, String specialty, int experience) {
        System.out.println("Попытка добавления пользователя в базу = " + user);
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        User developer = new User(user, age, specialty, experience);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }
    @Override
    public Integer addDeveloper(User user) {
        System.out.println("Попытка добавления пользователя в базу = " + user.getName());
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Integer developerId = null;
        transaction = session.beginTransaction();
        session.update(user);
/*
        if(user.getId() == 0){ // if user id is 0 then creating user other updating user
            session.save(user);
        } else {
            session.update(user);
        }
*/

        transaction.commit();
        session.close();
        return developerId;
    }
    @Override
    public boolean findUser(String user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List<User> developers = session.createQuery("FROM User").list();
        session.close();
        return user.contains(user);
    }
    @Override
    public void updateDeveloper(int developerId, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
    User developer = (User) session.get(User.class, developerId);
       // developer.setExperience(experience);
        session.update(developer);
        transaction.commit();
        session.close();
    }
    @Override
    public void removeDeveloper(int developerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User developer = (User) session.get(User.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
    @Override
    public List<User> listDevelopersReturn() {
        List<User> users;
        //Session session = getCurrentSession();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        users = session.createQuery("FROM User").list();
        session.close();
        Collections.sort(users);
        return users;
    }
    @Override
    public List<User> getAllUsers(String user){
        List<User> allUsers;
        List<User> users = new ArrayList<User>();
        //Session session = getCurrentSession();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        allUsers = session.createQuery("FROM User").list();
        session.close();
        for (User us: allUsers){
            if (user.equals(us.getName())){
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
        Session session = sessionFactory.openSession();
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


}
