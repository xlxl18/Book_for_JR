package net.proselyte.hibernate.servise;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import net.proselyte.hibernate.annotations.Book;
import net.proselyte.hibernate.dao.BookDAOHibernate;
import net.proselyte.hibernate.servise.Json.JsonObject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "init")
public class BookServiceImplTest {
    @Mock
    private BookDAOHibernate bookDAOHibernate;;

    @InjectMocks
    BookServiceImpl bookServiceImpl;

    @Spy
    List<Book> employees = new ArrayList<>();

    @Spy
    private Book book = new Book();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        employees = getBookList();
        book = getBook();
    }

    @Test
    public void addBook() {//addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready)
        doNothing().when(bookDAOHibernate).addBook(anyString(),anyString(),anyString(),anyString(), anyInt(),  anyBoolean());
        bookDAOHibernate.addBook(book.getTitle(), book.getDescription(), book.getAuthor(), book.getIsbn(), book.getPrintYear(), book.isReadAlready() );
        verify(bookDAOHibernate, atLeastOnce()).addBook(book.getTitle(), book.getDescription(), book.getAuthor(), book.getIsbn(), book.getPrintYear(), book.isReadAlready());
    }
    @Test
    public void updateBook() {
        when(bookDAOHibernate.updateBook(book)).thenReturn(1);
        Assert.assertEquals((int)bookDAOHibernate.updateBook(book), 1);
        verify(bookDAOHibernate, atLeastOnce()).updateBook(book);
    }
    @Test
    public void removeBook() {
        doNothing().when(bookDAOHibernate).removeBook(book.getId());
        bookDAOHibernate.removeBook(book.getId());
        verify(bookDAOHibernate, atLeastOnce()).removeBook(book.getId());
    }
    @Test
    public void getAllBooks() {
        when(bookDAOHibernate.getAllBooks(book.getTitle())).thenReturn(employees);
        Assert.assertEquals(bookDAOHibernate.getAllBooks(book.getTitle()), employees);
        verify(bookDAOHibernate, atLeastOnce()).getAllBooks(book.getTitle());

    }
    @Test
    public void getBook1(){
        when(bookDAOHibernate.getBook(book.getId())).thenReturn(book);
        Assert.assertEquals(bookDAOHibernate.getBook(book.getId()), book);
        verify(bookDAOHibernate, atLeastOnce()).getBook(book.getId());
    }
    @Test
    public void listBooksReturnFROM(){
        when(bookDAOHibernate.listBooksReturnFROM(anyInt(), anyInt(), anyString())).thenReturn(employees);
        Assert.assertEquals(bookDAOHibernate.listBooksReturnFROM(anyInt(), anyInt(), anyString()), employees);
        verify(bookDAOHibernate, atLeastOnce()).listBooksReturnFROM(anyInt(), anyInt(), anyString());


    }
    @Test
    public void getCountBooks(){
        when(bookDAOHibernate.getCountBooks()).thenReturn(12345);
        Assert.assertEquals(bookDAOHibernate.getCountBooks(), 12345);
        verify(bookDAOHibernate, atLeastOnce()).getCountBooks();
    }

    private List<Book> getBookList(){
        Book book = new Book();
        book.setTitle("Zaza");
        book.setDescription("Az123");
        book.setAuthor("asdfgf");
        book.setIsbn("555");
        book.setPrintYear(2016);
        book.setReadAlready(false);


        Book book2 = new Book();
        book.setTitle("Aza");
        book.setDescription("za321");
        book.setAuthor("qwerty");
        book.setIsbn("444");
        book.setPrintYear(2017);
        book.setReadAlready(true);


        employees.add(book);
        employees.add(book2);
        return employees;
    }
    private Book getBook(){
        book = new Book();
        book.setTitle("Iona");
        book.setId(3);
        return book;
    }
}
