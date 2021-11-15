package com.chatbonfire.server.Responses;

public class ErrorResponse {
    public Boolean error;
    public Integer code;
    public String message;
    public ErrorResponse(String message) {
        this.error = true;
        this.code = 500;
        this.message = message;
    }
}