package com.codegym.dao;

import com.codegym.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password"; // ĐỔI MẬT KHẨU TẠI ĐÂY

    public UserDAO() {}

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

    // --- CÁC PHƯƠNG THỨC CŨ (BỎ QUA CHI TIẾT ĐỂ TẬP TRUNG VÀO SP) ---
    @Override public void insertUser(User user) throws SQLException {}
    @Override public User selectUser(int id) { return null; }
    @Override public List<User> selectAllUsers() { return new ArrayList<>(); }
    @Override public boolean deleteUser(int id) throws SQLException { return false; }
    @Override public boolean updateUser(User user) throws SQLException { return false; }
    @Override public List<User> searchByCountry(String country) { return new ArrayList<>(); }
    @Override public List<User> sortByName() { return new ArrayList<>(); }
    @Override public void addUserTransaction(User user, int[] permissionIds) throws SQLException {}

    // --- STORED PROCEDURES TỪ BÀI TRƯỚC ---
    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?, ?, ?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.executeUpdate();
        }
    }

    // ========================================================
    // STORED PROCEDURES CHO BÀI TẬP HIỆN TẠI (GET ALL, UPDATE, DELETE)
    // ========================================================

    @Override
    public List<User> selectAllUsersStore() {
        List<User> users = new ArrayList<>();
        String query = "{CALL get_all_users()}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getString("email"), 
                    rs.getString("country")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return users;
    }

    @Override
    public boolean updateUserStore(User user) throws SQLException {
        boolean rowUpdated;
        String query = "{CALL update_user(?, ?, ?, ?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            rowUpdated = callableStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUserStore(int id) throws SQLException {
        boolean rowDeleted;
        String query = "{CALL delete_user(?)}";
        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
