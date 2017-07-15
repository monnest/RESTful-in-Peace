<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Patient</h1>
        <form:form action="savePatient" method="post" commandName="patient">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address" /></td>
            </tr>
            <tr>
                <td>Telephone:</td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td>Disease:</td>
                <td><form:input path="diseaseName" /></td>
            </tr>
            <tr>
                <td>Doctor Name:</td>
                <td>
                       <form:select path="doctorId" name="doctorId">
                           <form:options items="${doctorList}" itemValue="doctorId" itemLabel="doctorName"/>
                       </form:select>

                        <%--  <form:select path="doctorId">
                              <form:option value="NONE" label="--- Select ---"/>
                              <form:options items="${doctorList}" />
                          </form:select>--%>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>