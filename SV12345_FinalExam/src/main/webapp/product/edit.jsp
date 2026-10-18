<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .container { width: 400px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { font-weight: bold; display: block; margin-bottom: 5px; }
        input[type="text"], input[type="number"] { width: 100%; padding: 10px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        .btn { padding: 10px 15px; background-color: #f39c12; color: white; border: none; cursor: pointer; border-radius: 4px; width: 100%; font-weight: bold; }
    </style>
</head>
<body>
    <div class="container">
        <h2 style="text-align: center;">Cập Nhật Sản Phẩm</h2>
        <form action="${pageContext.request.contextPath}/products?action=edit" method="post">
            <input type="hidden" name="id" value="<c:out value='${requestScope.product.id}'/>" />
            <div class="form-group"><label>Tên sản phẩm:</label><input type="text" name="name" value="<c:out value='${requestScope.product.name}'/>" required /></div>
            <div class="form-group"><label>Giá:</label><input type="number" step="0.01" name="price" value="<c:out value='${requestScope.product.price}'/>" required /></div>
            <div class="form-group"><label>Số lượng:</label><input type="number" name="quantity" value="<c:out value='${requestScope.product.quantity}'/>" required /></div>
            <button type="submit" class="btn">Lưu Thay Đổi</button>
        </form>
        <p style="text-align: center;"><a href="${pageContext.request.contextPath}/products">Quay lại danh sách</a></p>
    </div>
</body>
</html>