package com.chatbonfire.server.Models;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public String mail;

    public String phone;

    public String password;

    public String name;

    public String last_name;

}