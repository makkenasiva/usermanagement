package com.learn.usermanagement.uservalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserValidationController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserValidationController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getUserpassword();

        if (userService.validateUser(username, password)) {
            String role = userService.getUserRoleByUsername(username);
            String token = jwtUtil.generateToken(username, role);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }

    // No "logout" endpoint here. Logout is handled on the client-side.

    @GetMapping("/get-role/{username}")
    public ResponseEntity<String> getUserRoleByUsername(@PathVariable String username) {
        String role = userService.getUserRoleByUsername(username);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
