package net.proselyte.hibernate.annotations;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HIBERNATE_DEVELOPERS")

public class User {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "NAME")
    private String name;
    @Column (name = "AGE")
    private int age;
    @Column (name = "isAdmin")
    private String isAdmin;
    @Column (name = "CREATEDDATE")
    private int date;

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Plain constructor
     */
    public User(String name, int age, String isAdmin, int date) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.date = date;
    }

    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int experience) {
        this.date = date;
    }
    /**
     * toString method (optional)
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isAdmin='" + isAdmin + '\'' +
                ", date=" + date +
                '}';
    }
}
