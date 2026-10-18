package com.codegym.dao;

import com.codegym.model.User;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    // Basic CRUD (PreparedStatement)
    public void insertUser(User user) throws SQLException;
    public User selectUser(int id);
    public List<User> selectAllUsers();
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;

    // Advanced Features
    public List<User> searchByCountry(String country);
    public List<User> sortByName();
    public void addUserTransaction(User user, int[] permissionIds) throws SQLException;

    // --- STORED PROCEDURES ---
    public User getUserById(int id);
    public void insertUserStore(User user) throws SQLException;
    
    // Yêu cầu mới của bài tập này
    public List<User> selectAllUsersStore();
    public boolean updateUserStore(User user) throws SQLException;
    public boolean deleteUserStore(int id) throws SQLException;
}
