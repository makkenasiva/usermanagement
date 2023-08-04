package com.learn.usermanagement.Forogotpassword;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String username;
    private String resetToken;
    private String newPassword;

    // Add getters and setters for the fields

    // Constructor (if necessary)
}
