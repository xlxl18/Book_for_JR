<%@ page import="java.util.Enumeration" %>
<%@ page import="net.proselyte.hibernate.annotations.User" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% Enumeration<String> form = request.getAttributeNames();
 Object form2 = request.getAttribute("userDate");
 User s = (User)form2;
%>

<html>
<head>
    <title>Add and edit user form</title>
</head>
<body>
<a href="viewusers">View All Users</a><br/>
<h1>${message}</h1>

<form:form method="post" commandName="user" action="${message2}">
 <table>
     <tr>
            <td>
                Name new User:
            </td>
            <td>
                <form:hidden path="id" value="${userDate.id}"/>
                <form:input path="name" value="${userDate.name}"/>
            </td>
     </tr>
     <tr>
         <td>
                Age new User:
         </td>
         <td>
                <form:input path="age" value="${userDate.age}"/>
         </td>
     </tr>
     <tr>
         <td>
                Are new User is Admin?
         </td>

         <td>

             <% //я - гений!!!!
                   if(s != null && s.getIsAdmin().equals("true")) {
              %>
             <form:radiobutton path="isAdmin" value="true" checked="true" />
             Yes
             <form:radiobutton path="isAdmin" value="false"  />
             No
             <%
                     }
                     else {
             %>
             <form:radiobutton path="isAdmin" value="true" />
             Yes
             <form:radiobutton path="isAdmin" value="false"  checked="true" />
             No
             <%
                 }
             %>

         </td>

     </tr>
     <tr>
         <td>
              new Date:
         </td>
         <td>

             <form:input path="date" value="${userDate.date}" />


         </td>
     </tr>

     <tr>
         <td colspan="2">
                <input type="submit" name="save"  value="Save user"onclick="return script();"/>
         </td>
         <td>
                <input type="reset" value="Reset" />
         </td>
     </tr>
 </table>
</form:form>


<!--fmt:formatDate var="fmtDate" value="${form.bean.dateProperty}" pattern="dd/MM/yyyy"/-->


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function script() {


        var name = $('#name').val().trim();
        var age = $('#age').val();
        var isAdmin = $('#isAdmin').val();
        if(name.length ==0) {
            alert('Please enter name of user');
            $('#name').focus();
            return false;
        }

        if(age <= 0 || age > 130) {
            alert('Please enter proper age');
            $('#age').focus();
            return false;
        }


        return true;
    };
</script>
</body>
</html>
<!--td><!--form:input path="date" type="datetime-local" step="1"/></td-->
<!--form:checkbox path="isAdmin" label="Would you like to join our mailinglist?" /-->