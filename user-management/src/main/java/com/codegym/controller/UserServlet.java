package com.codegym.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Controller xử lý các request HTTP (GET, POST) cho User.
 * Map tới endpoint: /users
 * YÊU CẦU: Sinh viên tự viết logic điều hướng (switch-case) và gọi tới UserDAO.
 */
@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // TODO: Xử lý request POST (thêm, sửa, xóa)
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // TODO: Xử lý request GET (hiển thị danh sách, hiển thị form)
    }
}
