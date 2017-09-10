package net.proselyte.hibernate.dao;
import net.proselyte.hibernate.annotations.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Repository //- указывает на то, что класс является репозиторием доступа к данным.
@Transactional //Перед исполнением метода помеченного данной аннотацией начинается транзакция,
// после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
public class UserJpiImpl implements UserDAOHibernate {
    @PersistenceContext // указывает на необходимость внедрения persistence контекста(entity manager).
    public EntityManager em;// менеджер сущностей

    @Override //готов
    public Integer addUser(String user, int age, byte isAdmin, Timestamp date) {
        User us = new User();
        us.setName(user);
        us.setAge(age);
        us.setIsAdmin(isAdmin);
        us.setDate(date);
        em.merge(us);

        return 5;
  }

    @Override //готов
    public Integer updateUser(User user) {
       em.refresh(user);
      return 5;
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
    @Override //готов
    public List<User> listUsersReturnFROM(int start, int maxRows, String searchParameter) {
        Query q = em.createQuery("from User");
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
        return em.createNamedQuery("User.getAll", User.class).getResultList().size();
    }
}
