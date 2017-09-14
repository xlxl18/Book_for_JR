package net.proselyte.hibernate.dao;
import net.proselyte.hibernate.annotations.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository //- указывает на то, что класс является репозиторием доступа к данным.
@Transactional //Перед исполнением метода помеченного данной аннотацией начинается транзакция,
// после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
public class UserJpiImpl implements UserDAOHibernate {
    @PersistenceContext // указывает на необходимость внедрения persistence контекста(entity manager).
    public EntityManager em;// менеджер сущностей

    @Override //готов
    public void addUser(String user, int age, byte isAdmin, Timestamp date) {
        User us = new User();
        us.setName(user);
        us.setAge(age);
        us.setIsAdmin(isAdmin);
        us.setDate(date);
        em.persist(us);
    }

    @Override //готов
    public Integer updateUser(User user) {
      return em.merge(user).getId();
    }
    @Override // готов
    public void removeUser(int id) {
       em.remove(getUser(id));
    }

    @Override // готов
    public List<User> getAllUsers(String nameOfUser){
        return em.createQuery("FROM User u").getResultList();
    }
    @Override // готов
    public User getUser(int id){
        return em.find(User.class, id);
    }
     //готов
    public List<User> listUsersReturnFROM2(int start, int maxRows, String searchParameter) {
        Query q = em.createQuery("from User u");
        if (null != searchParameter && !searchParameter.equals("")) {
            q = em.createQuery("FROM User WHERE name=?");
            q.setParameter(searchParameter, User.class );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    public List<User> listUsersReturnFROM(int start, int maxRows, String name) {
        TypedQuery <User> q = em.createNamedQuery("User.getAll", User.class);
        if (null != name && !name.equals("")) {
            q = em.createNamedQuery("User.getFrom", User.class);
            q.setParameter("name", name );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    @Override // готов
    public int getCountUsers(){
        return em.createNamedQuery("User.getAll", User.class).getResultList().size();
    }
}
