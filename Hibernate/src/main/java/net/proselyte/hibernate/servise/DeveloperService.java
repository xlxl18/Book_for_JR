package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.Developer;

import java.util.List;

public interface DeveloperService {

    Integer addDeveloper(String firstName, String lastName, String specialty, int experience);
    void removeDeveloper(int developerId);
    void listDevelopers();
    void updateDeveloper(int developerId, int experience);
    List<Developer> listDevelopersReturn();
}
