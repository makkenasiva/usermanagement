package com.learn.usermanagement.userinformation.usercontroller;
import com.learn.usermanagement.userinformation.userclass.UserModel;
import com.learn.usermanagement.userinformation.userservice.UserServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class Controller {

    private final UserServic userServic;

    @Autowired
    public Controller(UserServic userServic) {
        this.userServic = userServic;
    }

    @PostMapping
    public void createUser(@RequestBody UserModel user) {
        userServic.createUser(user);
    }
}