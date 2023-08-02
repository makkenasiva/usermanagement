package com.learn.usermanagement.userinformation.userservice;
import com.learn.usermanagement.userinformation.userclass.UserModel;
import com.learn.usermanagement.userinformation.userrepository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServic {
    @Autowired
    private  UserRepo userRepository;



    public String createUser(UserModel user) {
        if (userRepository.isUsernameExists(user.getUsername())) {
            return "Username already exists"; // Return custom message
        }

        userRepository.createUser(user);
        return "User created successfully"; // Return success message
    }


}