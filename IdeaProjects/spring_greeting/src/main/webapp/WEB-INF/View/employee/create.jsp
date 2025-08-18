<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 4/10/2025
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<%--@elvariable id="employee" type="com.example.spring_greeting.model.Employee"--%>
<form:form action="addEmployee" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID:</form:label></td>
            <td><form:input  path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber"><C></C></form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
