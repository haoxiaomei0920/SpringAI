package org.example.ai.controller;

public class ChatRequest {

    private String messages;
    private String model; // "openai" or "deepseek"

    // getters and setters


    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
