package org.example.ai.controller;

public class ChatRequest {

    private String message;
    private String model; // "openai" or "deepseek"

    // getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
