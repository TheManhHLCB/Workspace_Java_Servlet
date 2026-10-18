<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cập nhật sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .form-container { background: white; padding: 20px; width: 400px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"] { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;}
        button { background-color: #f39c12; color: white; border: none; padding: 10px; width: 100%; cursor: pointer; border-radius: 4px; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Sửa thông tin sản phẩm</h2>
        <c:if test="${not empty message}"><p style="color: green;">${message}</p></c:if>
        <form action="${pageContext.request.contextPath}/products?action=edit" method="POST">
            <input type="hidden" name="id" value="${product.id}" />
            <div class="form-group"><label>Tên sản phẩm:</label><input type="text" name="name" value="${product.name}" required /></div>
            <div class="form-group"><label>Giá:</label><input type="number" name="price" step="0.01" value="${product.price}" required /></div>
            <div class="form-group"><label>Mô tả:</label><input type="text" name="description" value="${product.description}" required /></div>
            <div class="form-group"><label>Nhà sản xuất:</label><input type="text" name="manufacturer" value="${product.manufacturer}" required /></div>
            <button type="submit">Cập nhật</button>
        </form>
        <br><a href="${pageContext.request.contextPath}/products">Quay lại danh sách</a>
    </div>
</body>
</html>