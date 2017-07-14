<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor Management Screen</title>
	<style type="text/css">
		#block_container
		{
			text-align:center;
		}
		#bloc1, #bloc2
		{
			display:inline;
			padding-left: 20px;
		}
	</style>
</head>
<div id="block_container">
	<%--<div align="left" id="bloc1">
		<a href="/login">Add Doctor</a>
	</div>--%>
	<div align="right" id="bloc2"> <a href="/login">Admin Login</a></div>
</div>
<body>
	<div align="center">
		<h1>Doctor List</h1>
		
		<table border="1">

			<th>Name</th>
			<th>Designation</th>
			<th>Action</th>

			<c:forEach var="doctor" items="${listDoctor}">
				<tr>
					<td>${doctor.doctorName}</td>
					<td>${doctor.designation}</td>
					<td><a href="/editDoctor?id=${doctor.doctorId}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteDoctor?id=${doctor.doctorId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

		</div>
</body>
<br/><br/><br/>
<div id="container" style="text-align:center;">
	<div align="left" id="bloc3" style="display:inline;padding-left: 20px;">
			<a href="/newDoctor">Add New Doctor</a>
	</div>
	<div align="right" id="bloc4" style="display:inline;padding-left: 20px;">
			<a href="/newPatient">Add New Patient</a>
	</div>
</div>
</html>