package net.proselyte.hibernate.annotations;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name= "hibernate_developers")
@ToString
@NamedQueries ({
           @NamedQuery(name = "User.getAll", query = "SELECT c from User c"),
           @NamedQuery(name = "User.getFrom", query = "SELECT c from User c WHERE c.name =: name")
})
public class User implements Comparable, Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column (name = "id")
    private int id;
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((User) o).getName());
    }




}
