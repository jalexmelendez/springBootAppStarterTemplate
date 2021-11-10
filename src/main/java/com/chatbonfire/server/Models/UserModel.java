package com.chatbonfire.server.Models;

import java.util.Objects;

public class UserModel {
    private final String id;

    private final String name;

    public UserModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userDto = (UserModel) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}