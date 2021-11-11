package com.chatbonfire.server.Responses;

import com.chatbonfire.server.Models.UserModel;

public class LoginResponse {
    public Object user;
    public Boolean is_logged;
    public String x_auth_token;
    public  LoginResponse(Object user, Boolean is_logged, String jwt) {
        this.user = user;
        this.is_logged = is_logged;
        this.x_auth_token = jwt;
    }
}