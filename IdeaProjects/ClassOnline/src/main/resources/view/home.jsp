<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get">
    <table >
        <tr>
            <td>#</td>
            <td>Ten lop</td>
            <td>So luong lop</td>
            <td>Mo ta</td>
            <td>NGAY</td>
            <td>Ten lop</td>
        </tr>
        <c:forEach var="classOnline" items="${classOnline}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${classOnline.className}</td>
                <td>${classOnline.studentCount}</td>
                <td>${classOnline.description}</td>
                <td>${classOnline.startDate}</td>
            </tr>
        </c:forEach>

    </table>

</form>

</body>
</html>
