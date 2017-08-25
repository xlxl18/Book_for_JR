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
    private String firstName;
    @Column (name = "AGE")
    private int age;
    @Column (name = "isAdmin")
    private String specialty;
    @Column (name = "CREATEDDATE")
    private int experience;

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Plain constructor
     */
    public User(String firstName, int age, String specialty, int experience) {
        this.firstName = firstName;
        this.age = age;
        this.specialty = specialty;
        this.experience = experience;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int lastName) {
        this.age = age;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * toString method (optional)
     */
    @Override
    public String toString() {
        return "Developer:\n" +
                "id: " + id +
                "\nFirst Name: " + firstName + "\n" +
                "Last Name: " + age + "\n" +
                "Specialty: " + specialty + "\n" +
                "Experience: " + experience + "\n";
    }
}
