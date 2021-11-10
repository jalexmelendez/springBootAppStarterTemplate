package com.chatbonfire.server.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.chatbonfire.server.Models.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {

    public  UserController() {}

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> getUsers() {
        return Arrays.asList(new UserModel("1", "Jorge"), new UserModel("2", "Jose"));
    }

}