package com.chatbonfire.server.Responses;

// Applies to edited (PUT) or deleted (DELETE) resources
public class ResourceModifiedResponse {

    public Boolean modified;

    public Object feedback;

    public ResourceModifiedResponse(Object feedback) {
        this.modified = false;
        this.feedback = feedback;
    }

}