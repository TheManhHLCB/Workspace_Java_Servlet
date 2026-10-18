<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý User</title>
</head>
<body style="font-family: Arial; padding: 20px;">
    <h2>Danh Sách Người Dùng (Test USE Transaction)</h2>
    
    <a href="${pageContext.request.contextPath}/users?action=test-use-tran" 
       style="padding: 10px 15px; background-color: #27ae60; color: white; text-decoration: none; border-radius: 4px; display: inline-block; margin-bottom: 20px;">
       Chạy Test: CÓ sử dụng Transaction (AutoCommit=false)
    </a>
    
    <table border="1" cellpadding="10" cellspacing="0" style="border-collapse: collapse; width: 80%;">
        <tr style="background-color: #1b2a7a; color: white;">
            <th>ID</th>
            <th>Tên User</th>
            <th>Email</th>
            <th>Quốc gia</th>
        </tr>
        <c:forEach var="user" items="${requestScope.listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.country}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>