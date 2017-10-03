package net.proselyte.hibernate.annotations;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table
@ToString
@NamedQueries ({
        @NamedQuery(name = "Book.getAll", query = "SELECT c from Book c"),
        @NamedQuery(name = "Book.getFrom", query = "SELECT c FROM Book c WHERE c.title = :title"),
})
public class Book implements Comparable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column
    private int id;
    @Getter
    @Setter
    @Column
    private String title;
    @Getter
    @Setter
    @Column
    private String description;
    @Getter
    @Setter
    @Column
    private String author;
    @Getter
    @Setter
    @Column
    private String isbn;
    @Getter
    @Setter
    @Column
    private int printYear;

    @Getter
    @Setter
    @Column
    private boolean readAlready;

    public Book() {
    }

    public Book(String title, String description, String author, String isbn, int printYear, boolean readAlready) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isbn = isbn;
        this.printYear = printYear;
        this.readAlready = readAlready;
    }

    @Override
    public int compareTo(Object o) {
        return title.compareTo(((Book) o).getTitle());
    }
}



