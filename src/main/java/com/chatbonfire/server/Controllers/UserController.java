package com.chatbonfire.server.Controllers;

import com.chatbonfire.server.Services.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import com.chatbonfire.server.Models.UserModel;
import com.chatbonfire.server.Models.UserLoginModel;
import com.chatbonfire.server.Responses.LoginResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> getUsers() {
        return Arrays.asList(new UserModel(1, "Jorge", "non"), new UserModel(2, "Jose", "na"));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse LoginUser(@RequestBody() UserLoginModel userLoginModel, @RequestHeader String x_auth_token) {
        try {
            LoginResponse res = new LoginResponse("NOT_FOUND", false, "NOT_FOUND");
            Object userLogged = UserLoginModel.Login(userLoginModel.mail, userLoginModel.password);
            if (userLogged instanceof UserModel) {
                UserModel userModel = (UserModel) userLogged;
                userModel.password = "PRIVATE_FIELD";
                res.user = userModel;
                res.is_logged = true;
                res.x_auth_token = UserLoginModel.Token(userModel);
            }
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
            LoginResponse err = new LoginResponse("SERVER_ERROR", false, e.toString());
            return err;
        }
    }

}