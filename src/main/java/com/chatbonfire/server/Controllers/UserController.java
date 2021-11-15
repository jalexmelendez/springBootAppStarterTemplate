package com.chatbonfire.server.Controllers;

import com.chatbonfire.server.Models.Repositories.UserRepository;
import com.chatbonfire.server.Responses.ErrorResponse;
import com.chatbonfire.server.Responses.ResourceCreatedResponse;
import com.chatbonfire.server.Responses.ResourceModifiedResponse;
import com.chatbonfire.server.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.chatbonfire.server.Models.UserModel;
import com.chatbonfire.server.Models.UserLoginModel;
import com.chatbonfire.server.Responses.LoginResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getUsers(@RequestHeader String x_auth_token) {
        try {
            //JWT auth
            if(AuthService.DecodeJwt(x_auth_token) == null) {
                return new ErrorResponse("INVALID_TOKEN");
            };
            return userRepository.findAll();
        }
        catch (Exception e) {
            System.out.println(e);
            return new ErrorResponse(e.toString());
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResourceCreatedResponse createUser(@RequestBody UserModel userModel) {
        try {
            ResourceCreatedResponse res = new ResourceCreatedResponse("User Created.");
            UserModel userExists = userRepository.findOneByMail(userModel.mail);
            if (userExists == null) {
                userModel.password = AuthService.hashData(userModel.password);
                userRepository.save(userModel);
                res.created = true;
            }
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResourceCreatedResponse(e.toString());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object deleteUser(@RequestHeader String x_auth_token) {
        try {
            if (AuthService.DecodeJwt(x_auth_token) == null) {
                return new ErrorResponse("INVALID_TOKEN");
            }
            Integer authTokenId = AuthService.DecodeJwt(x_auth_token);
            UserModel currentUser = userRepository.findById(authTokenId).get();
            userRepository.delete(currentUser);
            return new ResourceModifiedResponse("Deleted.");
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResourceModifiedResponse(e.toString());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object editUser(@RequestHeader String x_auth_token, @RequestBody UserModel userModel) {
        try {
            if (AuthService.DecodeJwt(x_auth_token) == null) {
                return new ErrorResponse("INVALID_TOKEN");
            }
            Integer authTokenId = AuthService.DecodeJwt(x_auth_token);
            UserModel currentUser = userRepository.findById(authTokenId).get();
            userModel.id = currentUser.id;
            userModel.password = currentUser.password;
            userRepository.save(userModel);
            ResourceModifiedResponse res = new ResourceModifiedResponse(userModel);
            res.modified = true;
            return res;
        }
        catch (Exception e) {
            System.out.println(e);
            return new ErrorResponse(e.toString());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponse LoginUser(@RequestBody UserLoginModel userLoginModel) {
        try {
            LoginResponse res = new LoginResponse("NOT_FOUND", false, "NOT_FOUND");
            String hashedPassword = AuthService.hashData(userLoginModel.password);
            Object userLogged = userRepository.findOneByMailAndPassword(userLoginModel.mail, hashedPassword);
            if (userLogged instanceof UserModel) {
                UserModel userModel = (UserModel) userLogged;
                res.user = userModel;
                res.is_logged = true;
                res.x_auth_token = AuthService.GenerateJwt(userModel);
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