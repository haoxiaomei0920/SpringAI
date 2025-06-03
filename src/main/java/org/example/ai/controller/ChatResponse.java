package org.example.ai.controller;

public class ChatResponse {

    private String response;
    private String modelUsed;

    public ChatResponse(String response, String modelUsed) {
        this.response = response;
        this.modelUsed = modelUsed;
    }

    // getters
    public String getResponse() {
        return response;
    }

    public String getModelUsed() {
        return modelUsed;
    }

}
