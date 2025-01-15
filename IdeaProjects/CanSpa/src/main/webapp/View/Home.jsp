<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/appointment?action=Add" methods="get">
        <button type="submit">Add</button>
    </a>
</div>
<div>
  <form method="post" action="/appointment?action=Search">
      <input name="keyword" type="text" placeholder="Search">
      <button type="submit">Search</button>

  </form>
</div>
<form method="get">
    <table border="1">
        <tr>
            <td>#</td>
            <td>Ten khach hang</td>
            <td>Ten dich vu</td>
            <td>Ngay hen</td>
            <td>Gio hen</td>
            <td>Action</td>
        </tr>
        <c:forEach var="appointment" items="${appointments}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${appointment.tenKhachHang}</td>
                <td>${appointment.tenDichVu}</td>
                <td>${appointment.ngayHen}</td>
                <td>${appointment.gioHen}</td>
                <td>
                    <a href="/appointment?action=Delete&maLichHen=${appointment.maLichHen}">Delete</a>
                    <a href="/appointment?action=Edit&maLichHen=${appointment.maLichHen}">Edit</a>
                    <a href="/appointment?action=Detail&maLichHen=${appointment.maLichHen}">Detail</a>
                </td>
            </tr>

        </c:forEach>
    </table>

</form>

</body>
</html>
