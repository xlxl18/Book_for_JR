package net.proselyte.hibernate.dao;


import net.proselyte.hibernate.annotations.Book;



import java.util.List;

public interface BookDAOHibernate {

     void addBook(String title, String description, String author, String isbn, int printYear, boolean readAlready);
     Integer updateBook(Book book);
     List<Book> getAllBooks(String nameOfBook);
     List<Book> listBooksReturnFROM(int start, int maxRows, String searchParameter);
     Book getBook(int id);
     int getCountBooks();
     void removeBook(int id);

}
