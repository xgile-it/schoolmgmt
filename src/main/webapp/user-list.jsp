<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>
</head>
<body>
	<center>
		<h1>User Management</h1>
        <h2>
        	<a href="new">Add New User</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Users</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>StuderNumber</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Grade</th>
                <th>Address</th>
                <th>Parent Contacts</th>
            </tr>
            <c:forEach var="students" items="${listUser}">
                <tr>
                    <td><c:out value="${students.studentNumber}" /></td>
                    <td><c:out value="${students.fname}" /></td>
                    <td><c:out value="${students.lname}" /></td>
                    <td><c:out value="${students.dob}" /></td>
                    <td><c:out value="${students.grade}" /></td>
                    <td><c:out value="${students.address}" /></td>
                    <td><c:out value="${students.parentContacts}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${students.studentNumber}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${students.studentNumber}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
