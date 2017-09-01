<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring pagination using data tables</title>
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
	<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
	<script type="text/javascript">

        //Plug-in to fetch page data
        jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
        {
            return {
                "iStart":         oSettings._iDisplayStart,
                "iEnd":           oSettings.fnDisplayEnd(),
                "iLength":        oSettings._iDisplayLength,
                "iTotal":         oSettings.fnRecordsTotal(),
                "iFilteredTotal": oSettings.fnRecordsDisplay(),
                "iPage":          oSettings._iDisplayLength === -1 ?
                    0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
                "iTotalPages":    oSettings._iDisplayLength === -1 ?
                    0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
            };
        };

        $(document).ready(function() {

            $("#example").dataTable( {
                "bProcessing": true,
                "bServerSide": true,
                "sort": "position",
                //bStateSave variable you can use to save state on client cookies: set value "true"
                "bStateSave": false,
                //Default: Page display length
                "iDisplayLength": 10,
                //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
                "iDisplayStart": 0,
                "fnDrawCallback": function () {
                    //Get page numer on client. Please note: number start from 0 So
                    //for the first page you will see 0 second page 1 third page 2...
                    //Un-comment below alert to see page number
                    //alert("Current page number: "+this.fnPagingInfo().iPage);
                },
                "sAjaxSource": "springPaginationDataTables.web",
                "aoColumns": [
                    { "mData": "name" },
                    { "mData": "position" },
                    { "mData": "office" },
                    { "mData": "phone" },
                    { "mData": "start_date" },
                    { "mData": "salary" },

                ]
            } );

        } );

	</script>
</head>

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