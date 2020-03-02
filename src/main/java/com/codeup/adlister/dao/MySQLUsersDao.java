package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        User returnUser = null;
        String sqlQuery = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(sqlQuery, Statement.NO_GENERATED_KEYS);
        stmt.setString(1, username);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
            Long id = rs.getLong(1);
            String uName = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            returnUser = new User(id, uName, email, password);
        }
        return returnUser;
    }

    @Override
    public Long insert(User user) throws SQLException {
        String sqlQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }

    public static void main(String[] args) throws SQLException {
        Users userDAO = DaoFactory.getUsersDao();
        User hunghly = userDAO.findByUsername("dude");
        System.out.println(hunghly.getUsername());
        User dude3 = new User("dude3", "dude3@email.com", "password3");
        System.out.println(userDAO.insert(dude3));
    }
}
