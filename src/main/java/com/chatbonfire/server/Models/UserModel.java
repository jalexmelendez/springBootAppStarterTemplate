package com.chatbonfire.server.Models;

import java.util.Objects;

public class UserModel {

    public final Integer id;

    public String mail;

    public String password;

    public UserModel(Integer id, String name, String password) {
        this.id = id;
        this.mail = name;
        this.password = password;
    }

}