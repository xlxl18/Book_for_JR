<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />


<head>
    <title>Getting Started: Handling Form Submission</title>
</head>
<body>
<a href="viewusers">View All Records</a><br/>
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
         <form:radiobutton path="isAdmin" value="true"/>
         Yes
         <form:radiobutton path="isAdmin" value="false"/>
         No
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
                <input type="submit" name="save"  value="Save new user"/>
         </td>
         <td>
                <input type="reset" value="Reset" />
         </td>
     </tr>
 </table>
</form:form>

<html>
<!--fmt:formatDate var="fmtDate" value="${form.bean.dateProperty}" pattern="dd/MM/yyyy"/-->

</html>

</body>
<!--td><!--form:input path="date" type="datetime-local" step="1"/></td-->
<!--form:checkbox path="isAdmin" label="Would you like to join our mailinglist?" /-->