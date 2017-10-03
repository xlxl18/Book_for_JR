<%@ page import="java.util.Enumeration" %>
<%@ page import="net.proselyte.hibernate.annotations.Book" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% Enumeration<String> form = request.getAttributeNames();
 Object form2 = request.getAttribute("bookDate");
 Book us = (Book)form2;
 %>

<html>
<head>
    <title>Add and edit Book form</title>
</head>
<body>
<a href="viewBooks">View All Books</a><br/>
<h1>${message}</h1>

<form:form method="post" commandName="book" action="${message2}">
 <table>
     <tr>
            <td>
                Title Book:
            </td>
            <td>
                <form:hidden path="id" value="${bookDate.id}"/>
                <form:input path="title" value="${bookDate.title}"/>
            </td>
     </tr>
     <tr>
         <td>
             Description:
         </td>
         <td>
                <form:input path="description" value="${bookDate.description}"/>
         </td>
     </tr>
     <tr>
         <td>
             ISBN:
         </td>
         <td>
             <form:input path="isbn" value="${bookDate.isbn}"/>
         </td>
     </tr>
     <tr>
         <td>
             Print Year:
         </td>
         <td>
             <form:input path="printYear" value="${bookDate.printYear}"/>
             <form:hidden path="readAlready" value="false"/>
             <form:hidden path="author" value="${bookDate.author}"/>
         </td>
     </tr>

     <!--tr>
         <td>
                Are User is Admin?
         </td>

         <td>

           //  <% //я - javaKing!!!! короче - это свич для загрузки isAdmin из БД.
          //         if(us != null && us.getIsAdmin() ==  1) {
           //   %>
          //   <!form:radiobutton path="isAdmin" value="1" checked="true" />
           //  Yes
           //  <!form:radiobutton path="isAdmin" value="1"  />
             No
           //  <%
           //          }
           //          else if(us != null && us.getIsAdmin() == 0)  {
           //  %>
           //  <!form:radiobutton path="isAdmin" value="1" />
          //   Yes
          //   <!form:radiobutton path="isAdmin" value="1"  checked="true" />
          //   No
          //   <%
          //       }
          //       else  if(us == null) {
          //   %>
             <!form:radiobutton path="isAdmin" value="1" />
             Yes
             <!form:radiobutton path="isAdmin" value="0"  checked="true" />
             No
         //    <%
         //        }
          //   %>
         </td>

     </tr-->

     <tr>
         <td colspan="2">
                <input type="submit" name="save"  value="Save book"onclick="return script();"/>
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
        var title = $('#title').val().trim();
        var description = $('#description').val().trim();
        var isbn = $('#isbn').val().trim();
        var printYear = $('#printYear').val();
        if(title.length ==0) {
            alert('Please enter Title of book');
            $('#title').focus();
            return false;
        }
        if(description.length ==0) {
            alert('Please enter description');
            $('#description').focus();
            return false;
        }
        if(isbn.length ==0) {
            alert('Please enter ISBN');
            $('#isbn').focus();
            return false;
        }

        if(printYear <= 0 || printYear > 2018) {
            alert('Please enter Print Year');
            $('#printYear').focus();
            return false;
        }
        return true;
    };
</script>
</body>
</html>