package com.learn.usermanagement.userinformation.usercontroller;
import com.learn.usermanagement.userinformation.userclass.UserModel;
import com.learn.usermanagement.userinformation.userrepository.UserRepo;
import com.learn.usermanagement.userinformation.userservice.UserServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class Controller {


    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public String createUser(@RequestBody UserModel user) {

        return  userRepo.createUser(user);


    }
}