package com.codegym.controller;
import com.codegym.strategy.*;
import com.codegym.model.Note;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoteManagementServlet", urlPatterns = "/notes")
public class NoteManagementServlet extends HttpServlet {
    private NoteStrategy strategy;

    public void init() {
        // Default to DB strategy. Can change to FileStrategy dynamically.
        strategy = new NoteDBStrategy(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            request.getRequestDispatcher("notes/create.jsp").forward(request, response);
        } else {
            request.setAttribute("notes", strategy.findAll());
            request.getRequestDispatcher("notes/list.jsp").forward(request, response);
        }
    }
}
