package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Repository
@Service("jpaContactService")
@Transactional
public class UserJpiImpl implements UserDAOHibernate {
    @PersistenceContext
    public EntityManager em;



    @Override //готов
    public Integer addUser(String user, int age, byte isAdmin, Timestamp date) {
        em.getTransaction().begin();
        em.merge(new User(user, age, isAdmin, date));
        em.getTransaction().commit();
        return 5;
  }

    @Override //готов
    public Integer updateUser(User user) {
        em.getTransaction().begin();
        em.refresh(user);
        em.getTransaction().commit();
        return 5;
    }
    @Override // готов
    public void removeUser(int id) {
        em.getTransaction().begin();
        em.remove(getUser(id));
        em.getTransaction().commit();
    }

    @Override // готов
    public List<User> getAllUsers(String nameOfUser){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
    @Override // готов
    public User getUser(int id){
        return em.find(User.class, id);

    }
    @Override //готов
    public List<User> listUsersReturnFROM(int start, int maxRows, String searchParameter) {

        Query q = em.createQuery("FROM User");
        if (null != searchParameter && !searchParameter.equals("")) {
            q = em.createQuery("FROM User WHERE  name=?");
            q.setParameter(searchParameter, User.class );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    @Override // готов
    public int getCountUsers(){
        return em.createNamedQuery("User.getAll", User.class).getMaxResults();
    }
}
