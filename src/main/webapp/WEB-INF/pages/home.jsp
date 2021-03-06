<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient Management Screen</title>
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
	<div align="left" id="bloc1">
		<a href="/viewList">Add Doctor</a>
	</div>
	<%--<div align="right" id="bloc2"> <a href="/login">Admin Login</a></div>--%>
	<a href="<c:url value="/logout" />">Logout</a>
</div>
<body>
	<div align="center">
		<h1>Patient List</h1>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<table border="1">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Disease</th>
			<th>Action</th>

			<c:forEach var="patient" items="${listPatient}">
				<tr>

					<td>${patient.name}</td>
					<td>${patient.email}</td>
					<td>${patient.address}</td>
					<td>${patient.telephone}</td>
					<td>${patient.diseaseName}</td>
					<td><a href="/editPatient?id=${patient.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletePatient?id=${patient.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Patient Register <a href="newPatient">Click here</a>
		</h4>
	</div>
</body>
</html>