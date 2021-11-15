package com.chatbonfire.server.Responses;

public class ResourceCreatedResponse {

    public Boolean created;

    public Object feedback;

    // Default response when resource not created.
    public ResourceCreatedResponse(String feedback) {
        this.created = false;
        this.feedback = feedback;
    }

}