package net.proselyte.hibernate.servise.servlets;


import net.proselyte.hibernate.annotations.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet  {
/*
    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private DeveloperDAOHibernate userDAOHibernate;

    public String getServletInfo(){
        return "Add user servlet";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx = getServletContext();

        if (request.getParameter("save")!=null){
            String user = request.getParameter("user");
            int age = Integer.parseInt(request.getParameter("age"));
             //String s = "1";  Boolean b = s.equals("1");
            Boolean isAdmin = request.getParameter("isAdmin").equals("1");
            String createdDate = request.getParameter("timestamp");
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = null;
            try {
                 date = format.parse(createdDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User newUser = new User();
            newUser.setName(user);
            newUser.setAge(age);
            newUser.setIsAdmin(isAdmin.toString());
            newUser.setDate(5);

            ctx.setAttribute("user", newUser);
            boolean res = userDAOHibernate.findUser(user);
            userDAOHibernate.addDeveloper(user, age, isAdmin.toString(), 5);

            if (res) {

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successRegistration");
                dispatcher.forward(request, response);
           } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adduser-error");
                dispatcher.forward(request, response);
            }
        } else if (request.getParameter("cancel")!=null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
    }
*/

}