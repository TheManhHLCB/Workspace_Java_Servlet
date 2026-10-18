package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DiscountServlet", urlPatterns = {"/display-discount"})
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            try {
                String description = request.getParameter("description");
                float price = Float.parseFloat(request.getParameter("price"));
                float discountPercent = Float.parseFloat(request.getParameter("discount"));
                
                // Tính toán
                float discountAmount = (float) (price * discountPercent * 0.01);
                float discountPrice = price - discountAmount;
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>Discount Result</title>");
                out.println("<style>");
                out.println("body { font-family: 'Arial', sans-serif; display: flex; justify-content: center; margin-top: 50px; background-color: #f4f7f6; }");
                out.println(".result-container { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); width: 450px; }");
                out.println("h2 { color: #2c3e50; text-align: center; border-bottom: 2px solid #ecf0f1; padding-bottom: 10px; }");
                out.println(".info { font-size: 16px; margin: 15px 0; color: #34495e; }");
                out.println(".highlight { color: #e74c3c; font-weight: bold; font-size: 20px;}");
                out.println("a { display: block; text-align: center; text-decoration: none; padding: 12px 20px; background-color: #2980b9; color: white; border-radius: 4px; margin-top: 20px; font-weight: bold; }");
                out.println("a:hover { background-color: #2471a3; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='result-container'>");
                out.println("<h2>Kết Quả Chiết Khấu</h2>");
                out.println("<div class='info'><strong>Mô tả sản phẩm:</strong> " + description + "</div>");
                out.println("<div class='info'><strong>Giá niêm yết:</strong> $" + price + "</div>");
                out.println("<div class='info'><strong>Tỷ lệ chiết khấu:</strong> " + discountPercent + "%</div>");
                out.println("<hr>");
                out.println("<div class='info'><strong>Lượng chiết khấu (Discount Amount):</strong> <span class='highlight'>$" + discountAmount + "</span></div>");
                out.println("<div class='info'><strong>Giá sau chiết khấu (Discount Price):</strong> <span class='highlight'>$" + discountPrice + "</span></div>");
                out.println("<a href='index.jsp'>Quay lại</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (NumberFormatException e) {
                out.println("<!DOCTYPE html><html><body><h2 style='color:red; text-align:center;'>Lỗi: Vui lòng nhập số hợp lệ cho giá và chiết khấu!</h2><div style='text-align:center;'><a href='index.jsp'>Quay lại</a></div></body></html>");
            }
        }
    }
}