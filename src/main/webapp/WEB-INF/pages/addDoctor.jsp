<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring MVC Form Handling</title>
</head>
<body><center>
    <div align="center">
        <h1>New/Edit Doctor</h1>
        <form:form action="saveDoctor" method="post" modelAttribute="doctor">
            <table>
                <form:hidden path="doctorId"/>
                <tr>
                    <td>Name:</td>
                    <td><form:input path="doctorName" /></td>
                </tr>
                <tr>
                    <td>Designation:</td>
                    <td><form:input path="designation" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
    <br/>
        <%--<table border="1">
            <th>Name</th>
            <th>Designation</th>
            <th>Action</th>

            <c:forEach var="doctor" items="${listDoctor}">
                <tr>
                    <td>${doctor.doctorName}</td>
                    <td>${doctor.designation}</td>
                    <td><a href="/editDoctor?id=${doctor.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deleteDoctor?id=${doctor.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>--%>
    <%--<h2><a href="addPublication.html">Adding Publication</a></h2>--%>
</center>
</body>
</html>