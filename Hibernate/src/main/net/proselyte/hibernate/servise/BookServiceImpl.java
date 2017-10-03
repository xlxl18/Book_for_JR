package net.proselyte.hibernate.servise;

import java.sql.Timestamp;
import net.proselyte.hibernate.annotations.Book;
import net.proselyte.hibernate.dao.BookDAOHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAOHibernate bookDAOHibernate;

    @Override
    public void addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        bookDAOHibernate.addBook( title,  description,  author,  isbn,  printYear,  readAlready);
    }
    @Override
    public Integer updateBook(Book title) {
        return bookDAOHibernate.updateBook(title);
    }
    @Override
    public void removeBook(int id) {
        bookDAOHibernate.removeBook(id);
    }
    @Override
    public List<Book> getAllBooks(String title) {
        return bookDAOHibernate.getAllBooks(title);
    }
    @Override
    public Book getBook(int id){
        return bookDAOHibernate.getBook(id);
    }
    @Override
    public List<Book> listBooksReturnFROM(int start, int maxRows, String searchParameter){
        return bookDAOHibernate.listBooksReturnFROM(start,maxRows,searchParameter);
    }
    @Override
    public int getCountBooks(){
        return bookDAOHibernate.getCountBooks();
    }

}