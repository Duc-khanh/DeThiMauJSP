<%--
  Created by IntelliJ IDEA.
  User: Khanh Nguyen
  Date: 4/9/2025
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Customer List</h2>
<p>There are ${customerList.size()} customers(s) in list.</p>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customer}" var="c">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td><a href="/customer/${c.id}">${c.name}</a></td>
            <td><c:out value="${c.email}"/></td>
            <<td> <c:out value="${c.email}"/></td>
            <td> <c:out value="${c.address}"/></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
