package com.learn.usermanagement.Forogotpassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private final CustomUserRepo customUserRepo;
    private final Map<String, String> resetTokens; // In-memory storage for reset tokens

    @Autowired
    public UserService(CustomUserRepo customUserRepo) {
        this.customUserRepo = customUserRepo;
        this.resetTokens = new HashMap<>();
    }

    public String generateResetToken(String username) {
        CustomUser user = customUserRepo.findByUsername(username);
        if (user == null) {
            return "User not found or invalid username";
        }

        // Generate reset token (you can use any method to generate the token)
        String resetToken = UUID.randomUUID().toString();

        // Store the reset token in the in-memory map (replace the previous token if it exists)
        resetTokens.put(username, resetToken);

        // Return the reset token to send to the user via email
        return resetToken;
    }

    public String resetPassword(String username, String resetToken, String newPassword) {
        // Retrieve the stored reset token for the user from the in-memory map
        String storedToken = resetTokens.get(username);

        if (storedToken == null || !storedToken.equals(resetToken)) {
            return "Invalid reset token";
        }

        // Reset password in the repository
        CustomUser user = customUserRepo.findByUsername(username);
        customUserRepo.updatePassword(user.getId(), newPassword);

        // Remove the reset token from the in-memory map since it has been used
        resetTokens.remove(username);

        return "Password reset successful";
    }
}
