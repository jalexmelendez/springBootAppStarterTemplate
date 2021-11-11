package com.chatbonfire.server.Models;

public class UserLoginModel {

    public final String mail;

    public final String password;

    public UserLoginModel(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public static Object Login(String mail, String password) {
        return 0;
    }

    public static String Token(UserModel user) {
        return "0";
    }

}