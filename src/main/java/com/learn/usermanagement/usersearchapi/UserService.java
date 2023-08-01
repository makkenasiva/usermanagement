package com.learn.usermanagement.usersearchapi;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;



@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchUsers(String query) {
        List<User> usersByFirstname = userRepository.findByFirstname(query);
        List<User> usersByUsername = userRepository.findByUsername(query);
        List<User> usersByEmail = userRepository.findByEmail(query);

        List<User> combinedResults = new ArrayList<>();
        combinedResults.addAll(usersByFirstname);
        combinedResults.addAll(usersByUsername);
        combinedResults.addAll(usersByEmail);

        return combinedResults;
    }
}




