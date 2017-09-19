package net.proselyte.hibernate;



import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.config.PersistenceJPAConfig;
import net.proselyte.hibernate.dao.UserJpiImpl;
import net.proselyte.hibernate.servise.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;


@ContextConfiguration(classes = {PersistenceJPAConfig.class, UserServiceImpl.class, UserJpiImpl.class, User.class, UserServiceImplTest.class})//(locations = { "file:src/test/test-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class UserServiceImplTest extends AbstractTestNGSpringContextTests {
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    private HibernateTemplate hibernateTemplate;


    @Bean
    @Autowired
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource, Properties additionalProperties) {
        LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
        asfb.setDataSource(dataSource);
        asfb.setHibernateProperties(additionalProperties);
        asfb.setPackagesToScan(new String[]{"test.net.proselyte.hibernate", "main.net.proselyte.hibernate"});
        return asfb;
    }
    // N.B. this will be wired AFTER @BeforeTest !!

    //@Bean
  //  @Autowired
    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
    {
        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
        return hibernateTemplate;
    }
/*
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
    {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sessionFactory);
        return htm;
    }


    @Test
    public void listEmployees(){
        when(service.findAllEmployees()).thenReturn(employees);
        Assert.assertEquals(appController.listEmployees(model), "allemployees");
        Assert.assertEquals(model.get("employees"), employees);
        verify(service, atLeastOnce()).findAllEmployees();
    }




    @Autowired
    UserServiceImpl subject;

    @BeforeMethod
    public void beforeMethod() {
        final HibernateTemplate ht = subject.getHibernateTemplate();
        ht.deleteAll(subject.listCustomers());
    }


    @Test
    public void noCustomers() {
        final List<CustomerDTO> customers = subject.listCustomers();
        assert customers != null : "listCustomers null result";
        LOG.info("listCustomers: " + customers);
        assert customers.size() == 0 : "Expected zero customers";

        final CustomerDTO customer = subject.findCustomerById(0L);
        assert customer == null : "Unexpected customer found";
    }

    @Test
    public void saveAndFind() {
        final CustomerDTO dto1 = makeDTO("0");
        final CustomerDTO saved = subject.save(dto1);
        assert saved != null ;

        final Long id1 = saved.getId();
        CustomerDTO customer = subject.findCustomerById(id1);
        assert customer != null ;
        assert customer.getId().equals(id1);
        assert customer.getTN().equals(dto1.getTN());

        List<CustomerDTO> customers = subject.listCustomers();
        assert customers != null : "listCustomers null result";
        LOG.info("saveAndFind - listCustomers: " + customers);
        assert customers.size() == 1 : "Expected one customer";

        subject.save(makeDTO("1"));

        customer = subject.findCustomerById(id1);
        assert customer != null ;
        assert customer.getId().equals(id1);

        customers = subject.listCustomers();
        assert customers != null : "listCustomers null result";
        LOG.info("saveAndFind - listCustomers: " + customers);
        assert customers.size() == 2 : "Expected two customers";
    }

    private CustomerDTO makeDTO(final String x) {
        final CustomerDTO dto = new CustomerDTO();
        dto.setX(x);
        return dto;
    }
*/
}
