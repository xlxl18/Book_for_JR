package net.proselyte.hibernate;
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
import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.controller.HelloController;
import net.proselyte.hibernate.servise.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Test(groups = "init")
public class HelloControllerTest {
    java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0");
    java.sql.Timestamp timestamp2 = java.sql.Timestamp.valueOf("2008-08-28 18:18:10.0");
    @Mock
    UserService service;

    @InjectMocks
    HelloController appController;

    @Spy
    List<User> employees = new ArrayList<User>();

    @Spy
    User user = new User();

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @BeforeClass
    public void setUp(){
        System.out.println("Start testing Controller");
        MockitoAnnotations.initMocks(this);
        employees = getUserList();
        user.setName("Iona");
        user.setId(3);
    }


    @Test
    public void viewusers(){
        Assert.assertEquals(appController.viewusers(), "viewusers");
    }

    @Test
    public void printWelcome(){
        Assert.assertEquals(appController.printWelcome(model), "index");
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

    @Test
    public void deleteUser(){
        doNothing().when(service).removeUser(anyInt());
        Assert.assertEquals(appController.deleteUser(1), "viewusers");
        verify(service, atLeastOnce()).removeUser(1);
    }

    @Test
    public void addUserForm(){
        Assert.assertEquals(appController.adduserform().getViewName(), "adduser");
        Assert.assertNotNull(appController.adduserform());
        Assert.assertNotNull(appController.adduserform().getModel().get("message"));
        Assert.assertNotNull(appController.adduserform().getModel().get("message2"));
        Assert.assertNotNull(appController.adduserform().getModel().get("user"));
    }

    @Test
    public void addUserForm2(){
        Assert.assertEquals(appController.adduserform(employees.get(0), model).getViewName(), "index");
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

    @Test
    public void editUserGET(){
        when(service.getUser(anyInt())).thenReturn(user);
        Assert.assertEquals(appController.editUser( anyInt(), user).getViewName(), "adduser");
        Assert.assertNotNull(appController.editUser(anyInt(), user));
        Assert.assertNotNull(appController.editUser(anyInt(), user).getModel().get("message"));
        Assert.assertNotNull(appController.editUser(anyInt(), user).getModel().get("message2"));
        Assert.assertEquals(appController.editUser(anyInt(), user).getModel().get("userDate"), user);
    }

    @Test
    public void editUserPOST(){
        when(service.updateUser(user)).thenReturn(3);
        Assert.assertEquals(appController.editUser(user, model).getViewName(), "index");
        Assert.assertNotNull(appController.editUser(user, model));
        Assert.assertNotNull(model.get("message"));
        Assert.assertNotNull(model.get("message2"));
    }

/*
    @Test
    public void saveEmployeeWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "registration");
    }

    @Test
    public void saveEmployeeWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "registration");
    }


    @Test
    public void saveEmployeeWithSuccess(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).saveEmployee(any(Employee.class));
        Assert.assertEquals(appController.saveEmployee(employees.get(0), result, model), "success");
        Assert.assertEquals(model.get("success"), "Employee Axel registered successfully");
    }

    @Test
    public void editEmployee(){
        Employee emp = employees.get(0);
        when(service.findEmployeeBySsn(anyString())).thenReturn(emp);
        Assert.assertEquals(appController.editEmployee(anyString(), model), "registration");
        Assert.assertNotNull(model.get("employee"));
        Assert.assertTrue((Boolean)model.get("edit"));
        Assert.assertEquals(((Employee)model.get("employee")).getId(), 1);
    }

    @Test
    public void updateEmployeeWithValidationError(){
        when(result.hasErrors()).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model,""), "registration");
    }

    @Test
    public void updateEmployeeWithValidationErrorNonUniqueSSN(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(false);
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model,""), "registration");
    }

    @Test
    public void updateEmployeeWithSuccess(){
        when(result.hasErrors()).thenReturn(false);
        when(service.isEmployeeSsnUnique(anyInt(), anyString())).thenReturn(true);
        doNothing().when(service).updateEmployee(any(Employee.class));
        Assert.assertEquals(appController.updateEmployee(employees.get(0), result, model, ""), "success");
        Assert.assertEquals(model.get("success"), "Employee Axel updated successfully");
    }


    @Test
    public void deleteEmployee(){
        doNothing().when(service).deleteEmployeeBySsn(anyString());
        Assert.assertEquals(appController.deleteEmployee("123"), "redirect:/list");
    }


    */



    public List<User> getUserList(){
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

}
