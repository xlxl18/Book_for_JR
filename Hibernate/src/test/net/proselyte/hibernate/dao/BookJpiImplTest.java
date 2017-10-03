package net.proselyte.hibernate.dao;

import net.proselyte.hibernate.annotations.Book;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class BookJpiImplTest extends EntityDaoImplTest {

    public EntityManager em;// менеджер сущностей

    @Autowired
    BookDAOHibernate bookDAOHibernate;

    @Test //готов
    public void addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPrintYear(printYear);
        book.setReadAlready(readAlready);
        em.persist(book);
    }

    @Test //готов
    public Integer updateBook(Book user) {
        return em.merge(user).getId();
    }
    @Test // готов
    public void removeBook(int id) {
        em.remove(id);
    }

    @Test // готов
    public List<Book> getAllBooks(String nameOfBook){
        return em.createQuery("FROM Book u").getResultList();
    }
    @Test // готов
    public Book getBook(int id){
        return em.find(Book.class, id);
    }
    //готов
    public List<Book> listBooksReturnFROM(int start, int maxRows, String name) {
        TypedQuery<Book> q = em.createNamedQuery("Book.getAll", Book.class);
        if (null != name && !name.equals("")) {
            q = em.createNamedQuery("Book.getFrom", Book.class);
            q.setParameter("name", name );
        }
        q.setFirstResult(start);
        q.setMaxResults(maxRows);

        return q.getResultList();
    }
    @Test // готов
    public int getCountBooks(){
        return em.createNamedQuery("Book.getAll", Book.class).getResultList().size();
    }


    @Override
    protected IDataSet getDataSet() throws Exception{
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Employee.xml"));
        return dataSet;
    }
}
