<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .header-actions { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        th, td { padding: 10px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #2c3e50; color: white; }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; display: inline-block; }
        .btn-add { background-color: #27ae60; }
        .btn-edit { background-color: #f39c12; }
        .btn-delete { background-color: #e74c3c; }
        .search-box { padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
    </style>
</head>
<body>
    <h2>Quản lý sản phẩm</h2>
    <div class="header-actions">
        <a href="${pageContext.request.contextPath}/products?action=create" class="btn btn-add">Thêm sản phẩm mới</a>
        <form action="${pageContext.request.contextPath}/products" method="GET">
            <input type="hidden" name="action" value="search" />
            <input type="text" name="keyword" class="search-box" placeholder="Nhập tên sản phẩm..." />
            <button type="submit" class="btn btn-add" style="border:none; cursor:pointer;">Tìm kiếm</button>
        </form>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá ($)</th>
            <th>Nhà sản xuất</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><a href="${pageContext.request.contextPath}/products?action=view&id=${product.id}">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.manufacturer}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/products?action=edit&id=${product.id}" class="btn btn-edit">Sửa</a>
                    <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}" class="btn btn-delete">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>