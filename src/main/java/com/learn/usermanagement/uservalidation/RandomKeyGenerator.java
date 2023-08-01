package com.learn.usermanagement.uservalidation;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomKeyGenerator {

    public static String generateRandomKey() {
        byte[] keyBytes = new byte[32]; // 32 bytes = 256 bits
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(keyBytes);
    }
}
