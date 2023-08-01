package com.learn.usermanagement.uservalidation;

public interface UserService {
    boolean validateUser(String username, String userpassword);

    String getUserRoleByUsername(String username);
}
