package net.proselyte.hibernate.servise;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.controller.HelloController;
import net.proselyte.hibernate.dao.UserDAOHibernate;
import net.proselyte.hibernate.servise.Json.UserJsonObject;
import net.proselyte.hibernate.servise.UserService;
import net.proselyte.hibernate.servise.UserServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import javax.servlet.http.HttpServletRequest;

@Test(groups = "init")
public class UserServiceImplTest  {
    @Mock
    private UserDAOHibernate userDAOHibernate;;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Spy
    List<User> employees = new ArrayList<>();

    @Spy
    private User user = new User();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        employees = getUserList();
        user = getUser();
    }

    @Test
    public void addUser() {
        doNothing().when(userDAOHibernate).addUser(anyString(), anyInt(), anyByte(), any());
        userDAOHibernate.addUser(user.getName(), user.getAge(), user.getIsAdmin(), user.getDate());
        verify(userDAOHibernate, atLeastOnce()).addUser(user.getName(), user.getAge(), user.getIsAdmin(), user.getDate());
    }
    @Test
    public void updateUser() {
        when(userDAOHibernate.updateUser(user)).thenReturn(1);
        Assert.assertEquals((int)userDAOHibernate.updateUser(user), 1);
        verify(userDAOHibernate, atLeastOnce()).updateUser(user);
    }
    @Test
    public void removeUser() {
        doNothing().when(userDAOHibernate).removeUser(user.getId());
        userDAOHibernate.removeUser(user.getId());
        verify(userDAOHibernate, atLeastOnce()).removeUser(user.getId());
    }
    @Test
    public void getAllUsers() {
        when(userDAOHibernate.getAllUsers(user.getName())).thenReturn(employees);
        Assert.assertEquals(userDAOHibernate.getAllUsers(user.getName()), employees);
        verify(userDAOHibernate, atLeastOnce()).getAllUsers(user.getName());

    }
    @Test
    public void getUser1(){
        when(userDAOHibernate.getUser(user.getId())).thenReturn(user);
        Assert.assertEquals(userDAOHibernate.getUser(user.getId()), user);
        verify(userDAOHibernate, atLeastOnce()).getUser(user.getId());
    }
    @Test
    public void listUsersReturnFROM(){
        when(userDAOHibernate.listUsersReturnFROM(anyInt(), anyInt(), anyString())).thenReturn(employees);
        Assert.assertEquals(userDAOHibernate.listUsersReturnFROM(anyInt(), anyInt(), anyString()), employees);
        verify(userDAOHibernate, atLeastOnce()).listUsersReturnFROM(anyInt(), anyInt(), anyString());


    }
    @Test
    public void getCountUsers(){
        when(userDAOHibernate.getCountUsers()).thenReturn(12345);
        Assert.assertEquals(userDAOHibernate.getCountUsers(), 12345);
        verify(userDAOHibernate, atLeastOnce()).getCountUsers();
    }

    private List<User> getUserList(){
        User user2 = new User();
        user2.setId(1);
        user2.setAge(25);
        user2.setName("Axel");
        user2.setIsAdmin((byte) 1);
        user2.setDate(timestamp);

        User user = new User();
        user.setId(2);
        user.setAge(30);
        user.setName("Jeremy");
        user.setIsAdmin((byte) 1);
        user.setDate(timestamp2);

        employees.add(user2);
        employees.add(user);
        return employees;
    }
    private User getUser(){
        user = new User();
        user.setName("Iona");
        user.setId(3);
        return user;
    }
    private java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
    private java.sql.Timestamp timestamp2 = java.sql.Timestamp.valueOf("2008-08-28 18:18:10.0");
}
