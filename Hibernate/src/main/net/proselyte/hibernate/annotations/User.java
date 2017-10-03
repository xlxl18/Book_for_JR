package net.proselyte.hibernate.annotations;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table
@ToString
@NamedQueries ({
           @NamedQuery(name = "User.getAll", query = "SELECT c from User c"),
           @NamedQuery(name = "User.getFrom", query = "SELECT c FROM User c WHERE c.name = :name"),
})
public class User implements Comparable, Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column (name = "id")
    private int id;
    @Getter
    @Setter
    @Column (name = "NAME")
    private String name;
    @Getter
    @Setter
    @Column (name = "AGE")
    private int age;
    @Getter
    @Setter
    @Column (name = "isAdmin")
    private byte isAdmin;
    @Getter
    @Setter
    @Column (name = "CREATEDDATE")
    private Timestamp date;

    public User() {}

    public User(String name, int age, byte isAdmin, Timestamp date) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((User) o).getName());
    }




}
