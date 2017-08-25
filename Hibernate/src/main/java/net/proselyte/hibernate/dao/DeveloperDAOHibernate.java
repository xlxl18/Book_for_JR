package net.proselyte.hibernate.dao;


import net.proselyte.hibernate.annotations.Developer;

import java.util.List;

public interface DeveloperDAOHibernate {

     Integer addDeveloper(String firstName, String lastName, String specialty, int experience);
     void removeDeveloper(int developerId);
     void listDevelopers();
     void updateDeveloper(int developerId, int experience);
     List<Developer> listDevelopersReturn();
}