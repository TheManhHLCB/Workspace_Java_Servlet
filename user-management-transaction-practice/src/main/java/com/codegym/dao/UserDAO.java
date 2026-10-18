package com.codegym.dao;

import com.codegym.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password"; // ĐỔI MẬT KHẨU TẠI ĐÂY

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users;")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("country")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void addUserTransaction(User user, int[] permissionIds) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmtUser = null;
        PreparedStatement pstmtAssignment = null;
        PreparedStatement pstmtError = null;
        ResultSet rs = null;
        
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            
            // 1. Chèn user
            String insertUserSql = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";
            pstmtUser = connection.prepareStatement(insertUserSql, Statement.RETURN_GENERATED_KEYS);
            pstmtUser.setString(1, user.getName());
            pstmtUser.setString(2, user.getEmail());
            pstmtUser.setString(3, user.getCountry());
            pstmtUser.executeUpdate();
            
            rs = pstmtUser.getGeneratedKeys();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            
            // =========================================================
            // ĐÂY LÀ ĐOẠN CỐ TÌNH GÂY LỖI THEO YÊU CẦU BÀI TẬP
            // Chèn vào một bảng không tồn tại để sinh ra SQLException
            // =========================================================
            System.out.println("Cố tình thực thi câu lệnh SQL lỗi để xem quá trình Rollback...");
            String errorSql = "INSERT INTO bang_khong_ton_tai (col1) VALUES (1)";
            pstmtError = connection.prepareStatement(errorSql);
            pstmtError.executeUpdate(); // Sẽ ném ra Exception tại đây!
            
            // 2. Chèn permission (Sẽ không bao giờ chạy tới đoạn này do lỗi ở trên)
            if (permissionIds != null && permissionIds.length > 0) {
                String insertPermissionSql = "INSERT INTO user_permission (user_id, permission_id) VALUES (?, ?)";
                pstmtAssignment = connection.prepareStatement(insertPermissionSql);
                for (int permissionId : permissionIds) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permissionId);
                    pstmtAssignment.executeUpdate();
                }
            }
            
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("=> ĐÃ BẮT ĐƯỢC LỖI SQL: " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("=> GIAO DỊCH (TRANSACTION) ĐÃ BỊ HỦY BỎ (ROLLBACK) THÀNH CÔNG!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmtUser != null) pstmtUser.close();
            if (pstmtAssignment != null) pstmtAssignment.close();
            if (pstmtError != null) pstmtError.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
}
