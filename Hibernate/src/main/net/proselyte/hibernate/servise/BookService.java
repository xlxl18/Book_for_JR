package net.proselyte.hibernate.servise;
import java.sql.Timestamp;

import net.proselyte.hibernate.annotations.Book;

import java.util.List;

public interface BookService {

    void addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready);
    Integer updateBook(Book book);
    List<Book> getAllBooks(String nameOfBook);
    List<Book> listBooksReturnFROM(int start, int maxRows, String searchParameter);
    Book getBook(int id);
    int getCountBooks();
    void removeBook(int id);


}
