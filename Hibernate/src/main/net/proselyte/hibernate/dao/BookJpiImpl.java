package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.Book;
import net.proselyte.hibernate.dao.BookDAOHibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

@Repository //- указывает на то, что класс является репозиторием доступа к данным.
@Transactional //Перед исполнением метода помеченного данной аннотацией начинается транзакция,
// после выполнения метода транзакция коммитится, при выбрасывании RuntimeException откатывается.
public class BookJpiImpl implements BookDAOHibernate {

    @PersistenceContext // указывает на необходимость внедрения persistence контекста(entity manager).
    public EntityManager em;// менеджер сущностей

    @Override //готов
    public void addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        Book us = new Book();
        us.setTitle(title);
        us.setDescription(description);
        us.setAuthor(author);
        us.setIsbn(isbn);
        us.setPrintYear(printYear);
        us.setReadAlready(readAlready);
        em.persist(us);
    }

    @Override //готов
    public Integer updateBook(Book book) {
      return em.merge(book).getId();
    }
    @Override // готов
    public void removeBook(int id) {
       em.remove(getBook(id));
    }

    @Override // готов
    public List<Book> getAllBooks(String nameOfBook){
        return em.createQuery("FROM Book u").getResultList();
    }
    @Override // готов
    public Book getBook(int id){
        return em.find(Book.class, id);
    }
     //готов
    public List<Book> listBooksReturnFROM(int start, int maxRows, String name) {
        TypedQuery <Book> q = em.createNamedQuery("Book.getAll", Book.class);
        if (null != name && !name.equals("")) {
            q = em.createNamedQuery("Book.getFrom", Book.class);
            q.setParameter("name", name );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    @Override // готов
    public int getCountBooks(){
        return em.createNamedQuery("Book.getAll", Book.class).getResultList().size();
    }


    private BookJpiImpl(){}

}
