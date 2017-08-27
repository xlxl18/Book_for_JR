<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<jsp:useBean id="userList" class="java.util.ArrayList" scope="request"/>
<a href="viewusers">View All Users</a><br/>

<h1>     Find users:    </h1>

<table border="1" width="90%">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Is admin?</th>
		<th>Created of Date</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${userList}" var="userList">
		<tr><td>${userList.id}</td>
			<td>${userList.name}</td>
			<td>${userList.age}</td>
			<td>${userList.isAdmin}</td>
			<td>${userList.date}</td>
			<td><a href="Tmp/editform.jsp?id=${u.getId()}">Edit</a></td>
			<td><a href="deleteUser?id=<c:out value='${userList.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>


</body>