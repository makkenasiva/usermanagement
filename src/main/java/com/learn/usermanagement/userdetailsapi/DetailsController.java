package com.learn.usermanagement.userdetailsapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class DetailsController {
    private DetailsService detailsService;

    @Autowired
    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping("/details")
    public ResponseEntity<Object> searchUser(@RequestParam Integer details) {
        UserDetails userDetails = detailsService.searchUser(details);
        if (userDetails != null) {
            // Return the user information
            Map<String, String> newDetails = new HashMap<>();
            newDetails.put("firstname", userDetails.getFirstname());
            newDetails.put("username", userDetails.getUsername());
            newDetails.put("user_password", userDetails.getUser_password());
            newDetails.put("email", userDetails.getEmail());
            newDetails.put("status", userDetails.getStatus());
            newDetails.put("institution_name", userDetails.getInstitution_name());
            newDetails.put("role_name", userDetails.getRole_name());
            return ResponseEntity.ok(newDetails);
        } else {
            // No user found
            Map<String, String> response = new HashMap<>();
            response.put("message", "No user available");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}

