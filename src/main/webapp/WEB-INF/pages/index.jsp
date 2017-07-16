<%--
  Created by IntelliJ IDEA.
  User: monnest
  Date: 7/16/2017
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESTful in Peace</title>
</head>
<body>
<h1>Hello, This is the public page. Please Login to get more access more functionality. </h1>
<h2>Add Doctor First</h2>
<h2>Admin login ---> username: admin  Pass: root123 </h2>
<h4>
    <p>Admin access is to Delete patient, but can't Edit</p>
</h4>
<h2>user login ---> username: user  Pass: user </h2>
<h4>
    <p>User access is to Edit patient, but can't Delete</p>
</h4>
<h>RESTful API Information</h>
<h4><p>All Data From Doctor Table -->http://localhost:8080/rest/doctors/all </p></h4>
<h4><p>Insert Data To Doctor Table -->http://localhost:8080/rest/doctors/add </p></h4>
<h4><p>Update Data To Doctor Table -->http://localhost:8080/rest/doctors/updateDoctor </p></h4>
<h4><p>Delete Data From Doctor Table -->http://localhost:8080/rest/doctors/deleteDoctor/{id} </p></h4>
<br><br><br>
<h1>Login For Admin Panel <a href="/login">Click here</a> </h1>
</body>
</html>
