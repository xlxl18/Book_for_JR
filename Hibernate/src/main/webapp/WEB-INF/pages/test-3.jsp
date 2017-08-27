<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
    <title>Getting Started: Handling Form Submission</title>
</head>
<body>
<a href="viewusers">View All Records</a><br/>
<h1>Add New User</h1>

<form:form method="post" commandName="user" action="adduserform">
    <table>
        <tr>
            <td><form:label path="name">Name new User:</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">AGE</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><form:label path="isAdmin">Are you Admin?</form:label></td>
           <!--td><!--form:input path="isAdmin" type="radio" value="1" />Yes</td-->
        </tr>
        <tr>
            <td><form:label path="date">CREATED DATE:</form:label></td>
            <!--td><!--form:input path="date" type="datetime-local" step="1"/></td-->
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



</body>
</html>