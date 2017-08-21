package net.proselyte.hibernate.servise;

import net.proselyte.hibernate.annotations.Developer;
import net.proselyte.hibernate.dao.DeveloperDAOHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("devHibernateService")
public class DeveloperServiceImpl  implements  DeveloperService {

    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private DeveloperDAOHibernate developerDAOHibernate;

    @Override
    public Integer addDeveloper(String firstName, String lastName, String specialty, int experience) {
        return developerDAOHibernate.addDeveloper(firstName, lastName, specialty, experience);
    }

    @Override
    public void removeDeveloper(int developerId) {

    }

    @Override
    public void listDevelopers() {

    }

    @Override
    public void updateDeveloper(int developerId, int experience) {

    }

    @Override
    public List<Developer> listDevelopersReturn() {
        return developerDAOHibernate.listDevelopersReturn();
    }
}
