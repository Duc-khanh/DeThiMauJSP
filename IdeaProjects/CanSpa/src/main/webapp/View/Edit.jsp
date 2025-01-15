
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>Tên khách hàng</td>
            <td><input type="text" name="tenKhachHang" value="${appointments.tenKhachHang}"></td>
        </tr>
        <tr>
            <td>Tên dịch vụ</td>
            <td><input type="text" name="tenDichVu" value="${appointments.tenDichVu}"></td>
        </tr>
        <tr>
            <td>Ngày Hẹn</td>
            <td><input type="date" name="ngayHen" value="${appointments.ngayHen}"></td>
        </tr>
        <tr>
            <td>Gio Hẹn</td>
            <td><input type="time" name="gioHen" value="${appointments.gioHen}"></td>
        </tr>
    </table>
    <button type="submit">Edit</button>
</form>

</body>
</html>
