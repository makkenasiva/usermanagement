package com.learn.usermanagement.uservalidation;

import java.util.HashSet;
import java.util.Set;

public class TokenBlacklist {

    private static final Set<String> BLACKLISTED_TOKENS = new HashSet<>();

    public static void addToBlacklist(String token) {
        BLACKLISTED_TOKENS.add(token);
    }

    public static boolean isTokenBlacklisted(String token) {
        return BLACKLISTED_TOKENS.contains(token);
    }
}
