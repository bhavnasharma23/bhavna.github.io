<%@ page import="com.web.application.test.model.Employee"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="com.web.application.test.repository.EmployeeRepository"%>

<%
	Employee employee = (Employee) request.getAttribute("updateEmployee");
	
	pageContext.setAttribute("updateEmployee", employee);
%>

<!DOCTYPE html>
<html>
<head>

<style>
table.listClass {
	width: 80%;
}

table.listClass, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

table.listClass th, td {
	padding: 5px;
	text-align: left;
}

table ..listClass #t01 th {
	background-color: red;
	color: white;
}
</style>

</head>
<body font-color="black">

	<form id="updateForm" method="post" action="EmployeeController">
		<div>
		<input type="hidden" name="sectionName" value="update">
		<input type="hidden" name="userName" value="${updateEmployee.userName}">
			<table border='0' width='300px' cellpadding='0' cellspacing='0'
				align='center'>
				<center>
					<tr>
						<td><h1>Registration Form</h1></td>
					</tr>
					<center>

						<table border='0' width='480px' cellpadding='0' cellspacing='0'
							align='center'>
							<tr>
								<td align='center'>First Name*</td>
								<td><input type="text" name='firstName' value = "${updateEmployee.firstName}"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Last Name*</td>
								<td><input type="text" name='lastName' value = "${updateEmployee.lastName}" ></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Email</td>
								<td><input type="email" name='emailAddress' value = "${updateEmployee.emailAddress}"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Phone No:</td>
								<td><input type="number" name='phoneNumber' value = "${updateEmployee.phoneNumber}"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Location</td>
								<td><input type="text" name='location' value = "${updateEmployee.location}"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<table border='0' cellpadding='0' cellspacing='0' width='120px'
								align='center'>
								<tr>
									<td align='center'><input type='submit' name='Update'
										value="update"></td>
								</tr>
							</table>
						</table>
			</table>

		</div>
	</form>

	
</body>
</html>