package net.proselyte.hibernate.dao;
import net.proselyte.hibernate.annotations.User;
import org.springframework.context.annotation.Bean;
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

                    // Singleton:
    private static final UserJpiImpl INSTANCE = new UserJpiImpl();
    //to prevent creating another instance of Singleton
    private UserJpiImpl(){}
    @Bean //по умолчанию Спринг создаст создан один бин а не много, но думаю синглтон все же уместен тут
    public static UserJpiImpl getUserJpiImpl(){
        return INSTANCE;
    }
}
