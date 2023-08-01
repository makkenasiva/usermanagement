package com.learn.usermanagement.uservalidation;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean validateUser(String username, String userpassword) {
        String sql = "SELECT COUNT(*) FROM `user` WHERE username = ? AND user_password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, userpassword);
        return count > 0;
    }

    @Override
    public String getUserRoleByUsername(String username) {
        String sql = "SELECT role_name FROM `user` WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, String.class, username);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
