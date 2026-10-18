package com.codegym.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Controller đóng vai trò điều hướng các request liên quan đến Customer (MVC).
 * Map tới endpoint: /customers
 * Lưu ý: Chỉ chứa chữ ký phương thức chuẩn, sinh viên tự triển khai luồng doGet/doPost.
 */
@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // TODO: Xử lý các request POST (create, edit, delete)
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // TODO: Xử lý các request GET (show list, show create form, show edit form...)
    }
}
