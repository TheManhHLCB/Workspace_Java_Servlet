<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.codegym.Customer" %>
<%-- LƯU Ý QUAN TRỌNG: Với Tomcat 10+, URI của JSTL phải là jakarta.tags.core thay vì http://java.sun.com/jsp/jstl/core --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    // Khởi tạo danh sách khách hàng và gắn vào request attribute
    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://i.pravatar.cc/150?img=11"));
    customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://i.pravatar.cc/150?img=12"));
    customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://i.pravatar.cc/150?img=13"));
    customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://i.pravatar.cc/150?img=14"));
    customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://i.pravatar.cc/150?img=15"));
    
    request.setAttribute("customers", customerList);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f8fafc; margin-top: 50px; }
        h2 { color: #1b2a7a; text-align: center; font-size: 28px; margin-bottom: 30px;}
        table { width: 80%; margin: 0 auto; border-collapse: collapse; background-color: white; box-shadow: 0 4px 10px rgba(0,0,0,0.1); border-radius: 8px; overflow: hidden;}
        th, td { border-bottom: 1px solid #ddd; padding: 15px; text-align: center; }
        th { background-color: #1b2a7a; color: white; font-weight: bold; text-transform: uppercase;}
        tr:hover { background-color: #f1f1f1; }
        img { width: 60px; height: 60px; border-radius: 50%; object-fit: cover; box-shadow: 0 2px 4px rgba(0,0,0,0.2); }
    </style>
</head>
<body>
    <h2>Danh sách khách hàng</h2>
    <table>
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <!-- Sử dụng thẻ JSTL c:forEach để lặp qua danh sách -->
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthDate}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.photo}" alt="Avatar"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>