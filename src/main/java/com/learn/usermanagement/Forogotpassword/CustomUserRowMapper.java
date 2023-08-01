package com.learn.usermanagement.Forogotpassword;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomUserRowMapper implements RowMapper<CustomUser> {

    @Override
    public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomUser user = new CustomUser();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("user_password"));
        user.setResetToken(rs.getString("reset_token"));
        return user;
    }
}
