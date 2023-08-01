package com.learn.usermanagement.Forogotpassword;

import lombok.Data;

@Data
public class CustomUser {
    private Integer id; // Use Integer for ID
    private String username;
    private String password;
    private String resetToken;


    // Constructors, getters, setters, and other methods as needed
}
