package com.codegym.dao;
import com.codegym.model.User;
import java.sql.SQLException;
import java.util.List;
public interface IUserDAO {
    public List<User> selectAllUsers();
    public void addUserTransaction(User user, int[] permissionIds) throws SQLException;
}
