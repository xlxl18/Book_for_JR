package net.proselyte.hibernate.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan({ "net.proselyte.hibernate" })// пакеты, в которых будет осуществлён поиск классов с описанием сущностей
@EnableTransactionManagement // — включает TransactionManager для управления транзакциями БД;
public class PersistenceJPAConfig{

    // Declare a JPA entityManagerFactory
    @Bean //
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setPackagesToScan(new String[] { "net.proselyte.hibernate" });
        lef.setJpaProperties(additionalProperties());

        return lef;
    }

    @Bean // - источник данных
    public DataSource dataSource(){
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/test");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("root");
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
        return datasource ;
    }
    // Declare a transaction manager
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean // JpaVendorAdapter - адаптер поставщика, вместо persistence.xml:
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    @Bean // капец нужная хрень для инекции из контейнера в PersistenceContext, угрохал кучу времени пока разобрался
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    @Bean
    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.c3p0.min_size", "7");
        properties.setProperty("hibernate.c3p0.max_size", "53");
        properties.setProperty("hibernate.c3p0.timeout", "100");
        properties.setProperty("hibernate.c3p0.max_statements", "150");
        properties.setProperty("hibernate.c3p0.idle_test_period", "1000");
        properties.setProperty("hibernate.c3p0.validate", "true");
        return properties;
    }



}

