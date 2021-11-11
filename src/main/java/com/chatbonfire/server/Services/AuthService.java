package com.chatbonfire.server.Services;

public class AuthService {

    private final static String PrivateKey = "0";

    public static String GenerateJwt() {
        return AuthService.PrivateKey;
    }

    public static String DecodeJwt() {
        return "";
    }

    public static String hashData() {
        return "";
    }

}