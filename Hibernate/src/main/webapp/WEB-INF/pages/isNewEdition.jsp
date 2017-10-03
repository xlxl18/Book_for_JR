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
    <title>Is new edition?</title>
</head>
<body>
<a href="viewBooks">View All Books</a><br/>


<td>
<form action="yesReadAlready?">
    <input type="hidden" name="id"   value="<%=us.getId()%>" />
    <button type="submit">This book is read</button>
</form>

<form action="editBook?">
    <input type="hidden" name="id"   value="<%=us.getId()%>" />
    <button type="submit">New edition of the book</button>
</form>
    </td>
</tr>
</body>
</html>