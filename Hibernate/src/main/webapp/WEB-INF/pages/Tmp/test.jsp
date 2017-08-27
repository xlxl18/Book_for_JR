<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%Calendar c= Calendar.getInstance();
    Date today = c.getTime();
    //Date dateFromDb = yourDateFromDatabase;
%>
<body>

<a href="viewusers">View All Records</a><br/>

<h1>Add New User</h1>
<form action="AddUser" method="post">
    <table>
        <tr><td>Name new User:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>AGE:</td><td><input type="number" name="age"/></td></tr>
        <tr><td>Are you Admin?:</td><td><input type="radio" name="isAdmin" value="1"/>Yes<input type="radio" name="isAdmin" value="0"/>No</td></tr>
        <tr><td>CREATED DATE:</td><td><input type="datetime-local" name="timestamp" step="1"></tr></td>


        <tr><td colspan="2"><input type="submit" name="save"  value="Save new user"/></td></tr>
    </table>
</form>

</body>