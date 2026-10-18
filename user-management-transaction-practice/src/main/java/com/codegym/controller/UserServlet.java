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

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            try {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                
                String[] permissionsStr = request.getParameterValues("permissions");
                int[] permissions = null;
                if (permissionsStr != null) {
                    permissions = new int[permissionsStr.length];
                    for (int i = 0; i < permissionsStr.length; i++) {
                        permissions[i] = Integer.parseInt(permissionsStr[i]);
                    }
                }
                
                User newUser = new User(name, email, country);
                userDAO.addUserTransaction(newUser, permissions);
                
                // Trả về kèm message báo lỗi đã bị rollback
                request.setAttribute("message", "Đã chạy transaction có lỗi. Kiểm tra CSDL xem User có bị lưu nháp không!");
                doGet(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("listUser", userDAO.selectAllUsers());
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
            dispatcher.forward(request, response);
        }
    }
}
