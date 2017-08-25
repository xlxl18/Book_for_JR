package net.proselyte.hibernate.dao;



import net.proselyte.hibernate.annotations.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//это и MAIN и DAO, MAIN убираем!!!!!!!
import java.util.List;
@Repository
public class UserRunner implements UserDAOHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
/*
    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding Developer's records to the database");
        Integer developerId1 = developerRunner.addDeveloper("Proselyte", "Developer", "Java Developer", 2);
        Integer developerId2 = developerRunner.addDeveloper("Some", "Developer", "C++ Developer", 2);
        Integer developerId3 = developerRunner.addDeveloper("Peter", "Team Lead", "Java Team Lead", 6);

        System.out.println("List of Developers:");
        developerRunner.listDevelopers();

        System.out.println("Removing \'Some Developer\' and updating \'Proselyte Developer\''s experience:");
        developerRunner.removeDeveloper(developerId2);
        developerRunner.updateDeveloper(developerId1, 3);

        System.out.println("Final list of Developers:");
        developerRunner.listDevelopers();
    }
    */


    @Override
    public Integer addUser(String name, int age, boolean isAdmin, Date createdDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        User developer = new User(name, age, isAdmin, createdDate);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }

    @Override
    public boolean findUser(String name) {
        Session session = sessionFactory.openSession();
        List<User> user = session.createQuery("FROM User").list();
        session.close();
        return user.contains(name);
    }

    @Override
    public void updateUser(int id, String name, int age, boolean isAdmin, Date createdDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        User user = (User) session.get(User.class, id);
        user.setName(name);
        user.setAge(age);
        user.setAdmin(isAdmin);
        user.setCreatedDate(createdDate);

        session.update(user);
        transaction.commit();
        session.close();
    }



    @Override
    public void removeUser(int developerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, developerId);
        session.delete(user);
        transaction.commit();
        session.close();
    }


    @Override
    public List<User> listUserReturn() {
        List<User> user;
        //Session session = getCurrentSession();
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        user = session.createQuery("FROM User").list();
        session.close();
        return user;

    }
}
