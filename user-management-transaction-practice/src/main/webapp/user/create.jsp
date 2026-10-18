<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Thêm Mới User</title></head>
<body style="font-family: Arial; padding: 20px;">
    <h2>Thêm Mới User (Cố Tình Sinh Lỗi)</h2>
    <form action="${pageContext.request.contextPath}/users?action=create" method="post">
        Tên: <input type="text" name="name" required /><br><br>
        Email: <input type="email" name="email" required /><br><br>
        Quốc gia: <input type="text" name="country" required /><br><br>
        <label><input type="checkbox" name="permissions" value="1"> Quyền Thêm</label>
        <label><input type="checkbox" name="permissions" value="2"> Quyền Sửa</label><br><br>
        <button type="submit" style="padding: 10px; background: red; color: white; border: none; cursor: pointer;">Lưu (Gây Lỗi Rollback)</button>
    </form>
    <br><a href="${pageContext.request.contextPath}/users">Quay lại</a>
</body>
</html>