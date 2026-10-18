<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý Sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        table { width: 80%; margin: 20px auto; border-collapse: collapse; background: white; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #2c3e50; color: white; }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; font-weight: bold; }
        .btn-add { background-color: #27ae60; display: inline-block; margin-bottom: 15px; margin-left: 10%; }
        .btn-edit { background-color: #f39c12; margin-right: 5px; }
        .btn-delete { background-color: #e74c3c; }
        h2 { text-align: center; color: #2c3e50; }
    </style>
</head>
<body>
    <h2>Hệ thống Quản lý Sản phẩm (Final Exam)</h2>
    <a href="${pageContext.request.contextPath}/products?action=create" class="btn btn-add">+ Thêm mới Sản phẩm</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="product" items="${requestScope.listProducts}">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.name}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td><c:out value="${product.quantity}" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}" class="btn btn-edit">Sửa</a>
                    <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}" class="btn btn-delete">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>