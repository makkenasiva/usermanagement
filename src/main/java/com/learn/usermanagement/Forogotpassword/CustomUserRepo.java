package com.learn.usermanagement.Forogotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomUserRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomUserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUsernameExists(String username) {
        String query = "SELECT COUNT(*) FROM user WHERE username = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, username);
        return count > 0;
    }

    public void createUser(CustomUser user) {
        String query = "INSERT INTO user (username, user_password) VALUES (?, ?)";
        jdbcTemplate.update(query, user.getUsername(), user.getPassword());
    }

    public CustomUser findByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ?";
        List<CustomUser> users = jdbcTemplate.query(query, new Object[]{username}, new BeanPropertyRowMapper<>(CustomUser.class));
        return users.isEmpty() ? null : users.get(0);
    }

    public void updatePassword(Integer userId, String password) {
        String query = "UPDATE user SET user_password = ? WHERE id = ?";
        jdbcTemplate.update(query, password, userId);
    }
}
