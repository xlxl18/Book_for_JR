
<html xmlns:th="http://www.thymeleaf.org">


<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<a href="viewusers">View All Records</a><br/>
<h1>Add New User</h1>
    <form action="#" th:action="@{/adduserform}" th:object="${user}" method="post">
    <table>
        <tr><td>Name new User:</td><td><input type="number" th:field="*{name}" /></td></tr>
        <tr><td>AGE:</td><td><input type="number" th:field="*{age}"/></td></tr>
        <tr><td>Are you Admin?:</td><td><input type="radio" th:field="*{isAdmin}" value="true"/>Yes<input type="radio" th:field="*{isAdmin}" value="false"/>No</td></tr>
        <tr><td>date:</td><td><input type="number" th:field="*{date}"/></td></tr>
        <tr><td>CREATED DATE:</td><td><!--input type="datetime-local" th:field="*{date}" step="1"--></tr></td>


        <tr><td colspan="2"><input type="submit" name="save"  value="Save new user"/></td><td><input type="reset" value="Reset" /></td></tr>
    </table>
</form>



</body>
</html>