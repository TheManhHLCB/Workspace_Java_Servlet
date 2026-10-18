<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .container { background: white; padding: 20px; width: 400px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        p { font-size: 16px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Chi tiết sản phẩm</h2>
        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Tên:</strong> ${product.name}</p>
        <p><strong>Giá:</strong> $${product.price}</p>
        <p><strong>Mô tả:</strong> ${product.description}</p>
        <p><strong>Nhà sản xuất:</strong> ${product.manufacturer}</p>
        <br><a href="${pageContext.request.contextPath}/products">Quay lại danh sách</a>
    </div>
</body>
</html>