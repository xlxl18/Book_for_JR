<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>


<h1>     All Users     </h1>

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
			<td><a href="editUser?id=<c:out value='${listResults.id}'/>">Edit</a></td>
			<td><a href="deleteUser?id=<c:out value='${listResults.id}'/>">Delete</a></td>
		</tr>
	</c:forEach>
</table>

<br/><a href="adduserform">Add New User</a>

<form action="searchUser">
	<div class="row">
		<div class="col-md-2">Search users by name:</div>
		<div class="col-md-2"><input type="text" name="searchName" id="searchName"
									 placeholder="type name here.."></div>
		<div class="col-md-2"><input class="btn btn-xs" type='submit' value='Search'/></div>
	</div>
</form>
</body>