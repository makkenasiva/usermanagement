package com.learn.usermanagement.Forogotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class ForgotPasswordController {

    private final UserS userS;

    @Autowired
    public ForgotPasswordController(UserS userS) {
        this.userS = userS;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String username) {
        String resetToken = userS.generateResetToken(username);
        if (resetToken.equals("User not found")) {
            return ResponseEntity.badRequest().body("User not found");
        }

        return ResponseEntity.ok("Password reset email sent successfully!");
    }
}
