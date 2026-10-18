package com.codegym;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Result</title></head>");
            out.println("<body style='font-family: Arial; padding: 50px;'>");
            out.println("<h2>Result:</h2>");

            try {
                float firstOperand = Float.parseFloat(request.getParameter("first-operand"));
                float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
                char operator = request.getParameter("operator").charAt(0);

                float result = Calculator.calculate(firstOperand, secondOperand, operator);
                
                out.println("<h3>" + firstOperand + " " + operator + " " + secondOperand + " = " + result + "</h3>");
            } catch (Exception ex) {
                out.println("<h3 style='color: red;'>Lỗi: " + ex.getMessage() + "</h3>");
            }
            
            out.println("<br><a href='index.jsp'>Quay lại (Back)</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
