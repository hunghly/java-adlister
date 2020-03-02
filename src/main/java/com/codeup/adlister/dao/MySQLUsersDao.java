package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public class MySQLUsersDao implements Users{

    public MySQLUsersDao(Config config) {

    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Long insert(User user) {
        return null;
    }
}
