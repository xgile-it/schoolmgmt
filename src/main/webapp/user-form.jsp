<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Management Application</title>

	<style>

	th{
        background:blue;
	    color:red;
	}
	h2{

	 color :blue;
	}

	td{

	background:blue;
	}


	</style>
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
		<c:if test="${students != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${students != null}">
            			Edit User
            		</c:if>
            		<c:if test="${students == null}">
            			Add New User
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${students != null}">
        			<input type="text" name="studentNumber" value="<c:out value='${students.studentNumber}' />" />
        		</c:if>            
            <tr>
                <th>User Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value="<c:out value='${students.fname}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Last name: </th>
                <td>
                	<input type="text" name="email" size="45"
                			value="<c:out value='${students.lname}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Date Of Birth: </th>
                <td>
                	<input type="text" name="country" size="15"
                			value="<c:out value='${students.dob}' />"
                	/>
                </td>
            </tr>

              <tr>
                            <th>Student Grade: </th>
                            <td>
                            	<input type="text" name="country" size="15"
                            			value="<c:out value='${students.grade}' />"
                            	/>
                            </td>
                        </tr>

                          <tr>
                                        <th>Address: </th>
                                        <td>
                                        	<input type="text" name="country" size="15"
                                        			value="<c:out value='${students.address}' />"
                                        	/>
                                        </td>
                                    </tr>


                                      <tr>
                                                    <th>Parent Contact: </th>
                                                    <td>
                                                    	<input type="text" name="country" size="15"
                                                    			value="<c:out value='${students.parentContacts}' />"
                                                    	/>
                                                    </td>
                                                </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
