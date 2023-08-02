package com.learn.usermanagement.userinformation.userrepository;


import com.learn.usermanagement.userinformation.userclass.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }






    public String createUser(UserModel user) {
        if (isUsernameExists(user.getUsername())) {
            return "Username already exists";

        }
        else {


        String sql = "INSERT INTO user (id, username, user_password, email, status, role_id,institution_id) VALUES (?, ?, ?, ?, ?, ?, ?)";


        jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getUser_password(), user.getEmail(), "Active", user.getRole_id(),user.getInstitution_id());
        return  "user details saved successfully";
    }
    }
    public boolean isUsernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }


}


