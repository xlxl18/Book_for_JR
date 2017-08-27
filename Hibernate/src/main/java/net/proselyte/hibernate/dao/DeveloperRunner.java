package net.proselyte.hibernate.dao;


import javassist.bytecode.stackmap.TypeData;
import net.proselyte.hibernate.annotations.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

//это и MAIN и DAO, MAIN убираем!!!!!!!
import java.util.List;
@Repository
public class DeveloperRunner implements DeveloperDAOHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public static void main(String[] args) {
 /*      sessionFactory = new Configuration().configure().buildSessionFactory();

        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding Developer's records to the database");
        Integer developerId1 = developerRunner.addDeveloper("Proselyte", 5, "Java Developer", 2);
        Integer developerId2 = developerRunner.addDeveloper("Some", "Developer", "C++ Developer", 2);
        Integer developerId3 = developerRunner.addDeveloper("Peter", "Team Lead", "Java Team Lead", 6);

        System.out.println("List of Developers:");
        developerRunner.listDevelopers();

        System.out.println("Removing \'Some Developer\' and updating \'Proselyte Developer\''s experience:");
        developerRunner.removeDeveloper(developerId2);
        developerRunner.updateDeveloper(developerId1, 3);

        System.out.println("Final list of Developers:");
        developerRunner.listDevelopers();
        */
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

    public Integer addDeveloper(User user) {
        System.out.println("Попытка добавления пользователя в базу = " + user.getName());
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        developerId = (Integer) session.save(user);
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
    public List<User> getAllUsers2(String userName){
        String query = "SELECT t.* FROM Test t WHERE t.name like '%"+ userName +"%'";
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        //List<Object[]> userObjects = sessionFactory.getCurrentSession().createSQLQuery(query).list();
        List<Object[]> userObjects = session.createQuery(query).list();
        List<User> users = new ArrayList<User>();
        for(Object[] userObject: userObjects) {
            User user = new User();
            int id = (int) userObject[0];
            String name = (String) userObject[1];
            int age = (int) userObject[2];
            String isAdmin = (String) userObject[3];
            int timestamp = (int) userObject[4];
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            user.setIsAdmin(isAdmin);
            user.setDate(timestamp);
            users.add(user);
        }
        System.out.println(users);
        return users;

    }


}
