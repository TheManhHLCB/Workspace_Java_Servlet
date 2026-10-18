<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xóa Sản phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; padding: 20px; }
        .container { width: 400px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); text-align: center; }
        .btn { padding: 10px 15px; color: white; border: none; cursor: pointer; border-radius: 4px; font-weight: bold; margin: 5px; }
        .btn-delete { background-color: #e74c3c; }
        .btn-cancel { background-color: #95a5a6; text-decoration: none; display: inline-block;}
    </style>
</head>
<body>
    <div class="container">
        <h2 style="color: #c0392b;">Xác Nhận Xóa</h2>
        <p>Bạn có chắc chắn muốn xóa sản phẩm <strong>${requestScope.product.name}</strong> không?</p>
        <form action="${pageContext.request.contextPath}/products?action=delete" method="post">
            <input type="hidden" name="id" value="${requestScope.product.id}" />
            <button type="submit" class="btn btn-delete">Đồng ý Xóa</button>
            <a href="${pageContext.request.contextPath}/products" class="btn btn-cancel">Hủy</a>
        </form>
    </div>
</body>
</html>