package net.proselyte.hibernate.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.proselyte.hibernate.annotations.Book;
import net.proselyte.hibernate.servise.Json.JsonObject;
import net.proselyte.hibernate.servise.BookService;
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
public class HelloControllerTest {
    private java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
    private java.sql.Timestamp timestamp2 = java.sql.Timestamp.valueOf("2008-08-28 18:18:10.0");

    @Mock
    private BookService service;

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private  HelloController appController;

    @Spy
    private List<Book> employees = new ArrayList<>();

    @Spy
    private Book user = new Book();

  /*  @Spy
    private  ModelMap model;

    @Mock
    private BindingResult result;

    @BeforeClass
    private void setUp(){
        System.out.println("Start testing Controller");
        MockitoAnnotations.initMocks(this);
        employees = getUserList();
        user = getUser();
    }


    @Test
    public void viewusers(){
        Assert.assertEquals(appController.viewusers(), "viewusers");
    }

    @Test
    private void printWelcome(){
        Assert.assertEquals(appController.printWelcome(model), "index");
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

    @Test
    public void deleteUser(){
        doNothing().when(service).removeBook(anyInt());
        Assert.assertEquals(appController.deleteUser(1), "viewusers");
        verify(service, atLeastOnce()).removeBook(1);
    }

    @Test
    private void addUserForm(){
        Assert.assertEquals(appController.adduserform().getViewName(), "adduser");
        Assert.assertNotNull(appController.adduserform());
        Assert.assertNotNull(appController.adduserform().getModel().get("message"));
        Assert.assertNotNull(appController.adduserform().getModel().get("message2"));
        Assert.assertNotNull(appController.adduserform().getModel().get("user"));
    }

    @Test
    private void addUserForm2(){
        Assert.assertEquals(appController.adduserform(employees.get(0), model).getViewName(), "index");
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

    @Test
    private void editUserGET(){
        when(service.getUser(anyInt())).thenReturn(user);
        Assert.assertEquals(appController.editUser( anyInt(), user).getViewName(), "adduser");
        Assert.assertNotNull(appController.editUser(anyInt(), user));
        Assert.assertNotNull(appController.editUser(anyInt(), user).getModel().get("message"));
        Assert.assertNotNull(appController.editUser(anyInt(), user).getModel().get("message2"));
        Assert.assertEquals(appController.editUser(anyInt(), user).getModel().get("userDate"), user);
    }

    @Test
    private void editUserPOST(){
        when(service.updateUser(user)).thenReturn(3);
        Assert.assertEquals(appController.editUser(user, model).getViewName(), "index");
        Assert.assertNotNull(appController.editUser(user, model));
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

    @Test
    private void springPaginationDataTables() throws IOException {
        when(request.getParameter("iDisplayLength")).thenReturn("10");
        when(request.getParameter("iDisplayStart")).thenReturn("10");
        when(appController.createPaginationDataOnSearchParameter(anyInt(),anyInt(),anyString())).thenReturn(employees);

        UserJsonObject userJsonObject = new UserJsonObject();
        userJsonObject.setiTotalDisplayRecords(service.getCountUsers());
        userJsonObject.setiTotalRecords(2);
        userJsonObject.setAaData(employees);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Assert.assertEquals(appController.springPaginationDataTables(request), gson.toJson(userJsonObject));
    }

    private List<Book> getUserList(){
        Book user2 = new User();
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

    */
}
