package com.learn.usermanagement.Forogotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/reset-password")
public class ResetPasswordController {

    private final UserS userS;

    @Autowired
    public ResetPasswordController(UserS userS) {
        this.userS = userS;
    }

    @GetMapping // GET request to generate the reset token
    public String generateResetToken(@RequestParam("username") String username) {
        String resetToken = userS.generateResetToken(username);
        System.out.println("Generated reset token: " + resetToken); // Log the reset token to the backend terminal
        return "Reset token generated";
    }

    @PostMapping("/resetpassword") // POST request to reset the password
    public String resetPassword(@RequestBody ResetPasswordRequest request) {
        String username = request.getUsername();
        String resetToken = request.getResetToken();
        String newPassword = request.getNewPassword();

        String result = userS.resetPassword(username, resetToken, newPassword);
        return result;
    }
}
