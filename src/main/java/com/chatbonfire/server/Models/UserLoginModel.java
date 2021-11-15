package com.chatbonfire.server.Models;

public class UserLoginModel {

    public final String mail;

    public final String password;

    public UserLoginModel(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

}