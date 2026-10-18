<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Xóa sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .container { background: white; padding: 20px; width: 400px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        button { background-color: #e74c3c; color: white; border: none; padding: 10px; cursor: pointer; border-radius: 4px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Xác nhận xóa sản phẩm</h2>
        <p>Bạn có chắc chắn muốn xóa sản phẩm <strong>${product.name}</strong> không?</p>
        <form action="${pageContext.request.contextPath}/products?action=delete" method="POST">
            <input type="hidden" name="id" value="${product.id}" />
            <button type="submit">Đồng ý Xóa</button>
            <a href="${pageContext.request.contextPath}/products" style="margin-left: 10px; text-decoration: none; color: #333;">Hủy bỏ</a>
        </form>
    </div>
</body>
</html>