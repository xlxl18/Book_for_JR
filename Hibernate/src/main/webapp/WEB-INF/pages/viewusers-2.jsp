<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>


<h1>     Users List    </h1>

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
	<c:forEach items="${listResults}" var="listResults">
		<tr><td>${listResults.id}</td>
			<td>${listResults.name}</td>
			<td>${listResults.age}</td>
			<td>${listResults.isAdmin}</td>
			<td>${listResults.date}</td>
			<td><a href="Tmp/editform.jsp?id=${u.getId()}">Edit</a></td>
			<td><a href="deleteUser?id=<c:out value='${listResults.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br/><a href="adduserform">Add New User</a>
</body>