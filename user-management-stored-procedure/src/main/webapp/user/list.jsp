<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý User</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f8fafc; }
        h2 { color: #1b2a7a; text-align: center; }
        .top-bar { width: 80%; margin: 20px auto; display: flex; justify-content: space-between; align-items: center; }
        table { width: 80%; margin: 0 auto; border-collapse: collapse; background: white; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #1b2a7a; color: white; }
        tr:hover { background-color: #f1f5f9; }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; font-weight: bold; font-size: 14px; display: inline-block; }
        .btn-add { background-color: #27ae60; }
        .btn-sort { background-color: #f39c12; margin-right: 10px; }
        .btn-edit { background-color: #2980b9; margin-right: 5px; }
        .btn-delete { background-color: #c0392b; }
        .search-box { padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
        .btn-search { background-color: #8e44ad; color: white; padding: 8px 12px; border: none; border-radius: 4px; cursor: pointer; font-weight: bold;}
    </style>
</head>
<body>
    <h2>Danh Sách Người Dùng (Stored Procedure Update)</h2>
    
    <div class="top-bar">
        <div>
            <a href="${pageContext.request.contextPath}/users?action=create" class="btn btn-add">Thêm mới User</a>
            <a href="${pageContext.request.contextPath}/users?action=sort" class="btn btn-sort">Sắp xếp theo Tên</a>
        </div>
        
        <form action="${pageContext.request.contextPath}/users" method="get">
            <input type="hidden" name="action" value="search" />
            <input type="text" name="country" class="search-box" placeholder="Nhập tên quốc gia..." value="${requestScope.searchKeyword}" required />
            <button type="submit" class="btn-search">Tìm kiếm</button>
            <c:if test="${not empty requestScope.searchKeyword}">
                <a href="${pageContext.request.contextPath}/users" style="margin-left:10px; text-decoration:none; color: #c0392b; font-weight:bold;">Xóa tìm kiếm</a>
            </c:if>
        </form>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên User</th>
            <th>Email</th>
            <th>Quốc gia</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="user" items="${requestScope.listUser}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.name}" /></td>
                <td><c:out value="${user.email}" /></td>
                <td><c:out value="${user.country}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}" class="btn btn-edit">Sửa</a>
                    <a href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}" class="btn btn-delete">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>