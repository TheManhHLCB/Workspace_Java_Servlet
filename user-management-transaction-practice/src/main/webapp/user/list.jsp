<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Quản lý User</title></head>
<body style="font-family: Arial; padding: 20px;">
    <h2>Danh Sách Người Dùng (Test Rollback)</h2>
    <p style="color: red; font-weight: bold;">${message}</p>
    <a href="${pageContext.request.contextPath}/users?action=create" style="padding: 10px; background: green; color: white; text-decoration: none;">Thêm User Mới</a>
    <br><br>
    <table border="1" cellpadding="10" style="border-collapse: collapse; width: 60%;">
        <tr style="background-color: #1b2a7a; color: white;">
            <th>ID</th><th>Tên User</th><th>Email</th><th>Quốc gia</th>
        </tr>
        <c:forEach var="user" items="${requestScope.listUser}">
            <tr>
                <td>${user.id}</td><td>${user.name}</td><td>${user.email}</td><td>${user.country}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>