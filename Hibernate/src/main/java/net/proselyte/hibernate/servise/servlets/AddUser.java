package net.proselyte.hibernate.servise.servlets;

import net.proselyte.hibernate.annotations.User;
import net.proselyte.hibernate.dao.UserDAOHibernate;
import net.proselyte.hibernate.servise.UserService;
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

    @Autowired
    @Qualifier("getNewDevHibernateDAO")
    private UserDAOHibernate userDAOHibernate;

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
            String createdDate = request.getParameter("date");
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
            newUser.setAdmin(isAdmin);
            newUser.setCreatedDate(date);

            ctx.setAttribute("user", newUser);

            boolean res = userDAOHibernate.findUser(user);

            if (res) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successRegistration.jsp");
                dispatcher.forward(request, response);
           } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adduser-error.jsp");
                dispatcher.forward(request, response);
            }
        } else if (request.getParameter("cancel")!=null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
    }
}