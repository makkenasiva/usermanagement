package com.learn.usermanagement.usersearchapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





@RestController
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{query}")
    public ResponseEntity<Object> searchUsers(@PathVariable("query") String query) {
        List<User> users = userService.searchUsers(query);
        if (!users.isEmpty()) {
            // Return a list of user information
            List<Map<String, String>> userDetailsList = new ArrayList<>();
            for (User user : users) {
                Map<String, String> userDetails = new HashMap<>();
                userDetails.put("firstname", user.getFirstname());
                userDetails.put("username", user.getUsername());
                userDetails.put("email", user.getEmail());
                userDetails.put("status", user.getStatus());
                userDetails.put("details",user.getDetails());
                userDetailsList.add(userDetails);
            }
            return ResponseEntity.ok(userDetailsList);
        } else {
            // No users found
            Map<String, String> response = new HashMap<>();
            response.put("message", "No users available");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}




