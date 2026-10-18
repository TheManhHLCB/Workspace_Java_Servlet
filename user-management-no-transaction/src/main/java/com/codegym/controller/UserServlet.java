package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                // Các case cũ...
                default:
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                // Thêm case mới cho chức năng test without transaction
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    // --- PHƯƠNG THỨC MỚI THÊM ĐỂ TEST ---
    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        // Gọi phương thức cố tình sinh lỗi
        userDAO.insertUpdateWithoutTransaction();
        System.out.println("Đã chạy xong hàm testWithoutTran. Hãy kiểm tra database!");
        
        try {
            // Cho phép in ra một phản hồi nhẹ trên trình duyệt để dễ nhìn
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h2>Đã thực thi test-without-tran!</h2>");
            response.getWriter().println("<p>Vui lòng kiểm tra Console trong IDE để xem SQLException.</p>");
            response.getWriter().println("<p>Sau đó mở MySQL chạy lệnh: <b>SELECT * FROM Employee;</b> để xem hiện tượng rác dữ liệu.</p>");
            response.getWriter().println("<br><a href='users'>Quay lại danh sách User</a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
