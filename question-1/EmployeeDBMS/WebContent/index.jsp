<%@ page import="com.web.application.test.model.Employee"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="com.web.application.test.repository.EmployeeRepository"%>

<%
	List<Employee> slist = (List<Employee>) request.getAttribute("list");
	if(slist==null)
	{
		EmployeeRepository employeeRepository = new EmployeeRepository();
		slist = employeeRepository.getAll();
	}
	pageContext.setAttribute("employeeList", slist);
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

	<form id="registrationForm" method="post" action="EmployeeController">
		<div>
		<input type="hidden" name="sectionName" value="registration">
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
								<td align='center'>Username*</td>
								<td><input type="text" name="userName"required ></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Password*</td>
								<td><input type="password" id= "password" name="password" required></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Confirm Password*</td>
								<td><input type="password" id ="confirmpassword" name="confirmpassword" required></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>First Name*</td>
								<td><input type="text" name="firstName" required></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Last Name*</td>
								<td><input type="text" name="lastName" required></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Email</td>
								<td><input type="email" name='emailAddress'></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Phone No:</td>
								<td><input type="number" name='phoneno'></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align='center'>Location</td>
								<td><input type="text" name='location'></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<table border='0' cellpadding='0' cellspacing='0' width='120px'
								align='center'>
								<tr>
									<td align='center'><input type='submit' name='Save'
										value="register"></td>
									<td align='center'><input type='reset' name='Reset'
										value="reset"></td>
								</tr>
							</table>
						</table>
			</table>

		</div>
	</form>

	<div>

		<table class="listClass" style="width: 100%">
			<tr>
				<th>Firstname</th>
				<th></th>
				<th>Lastname</th>
				<th></th>
				<th>Email</th>
				<th></th>
				<th>PhoneNo.</th>
				<th></th>
				<th>Location</th>
				<th></th>
				<th>Operations</th>
				
			</tr>


				<c:forEach items="${employeeList}" var="employee">
				<tr>
					<td><c:out value="${employee.firstName}" />
					<td>
					<td><c:out value="${employee.lastName}" />
					<td>
					<td><c:out value="${employee.emailAddress}" />
					<td>
					<td><c:out value="${employee.phoneNumber}" />
					<td>
					<td><c:out value="${employee.location}" />
					<td>
					<td><span> <a href="/EmployeeDBMS/EmployeeController?action=edit&userName=${employee.userName}&firstName=${employee.firstName}&lastName=${employee.lastName}&emailAddress=${employee.emailAddress}&phoneNumber=${employee.phoneNumber}&location=${employee.location}">Edit </a></span><span> </span> <span>
						<a href="/EmployeeDBMS/EmployeeController?action=delete&userName=${employee.userName}">Delete </a>
				</span></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	
	<script type="text/javascript">
	var password = document.getElementById("password")
	  , confirm_password = document.getElementById("confirmpassword");
	console.log(password);
	

	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	</script>
	
</body>
</html>