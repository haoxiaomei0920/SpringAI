package org.example.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiSimpleController {

    private final ChatClient openAiChatClient;
    private final ChatClient deepSeekChatClient;

    @Autowired
    public AiSimpleController (
            @Qualifier("openAiChatClient") ChatClient openAiChatClient,
            @Qualifier("deepSeekChatClient") ChatClient deepSeekChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.deepSeekChatClient = deepSeekChatClient;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        ChatClient selectedClient = request.getModel().equals("openai")
                ? openAiChatClient
                : deepSeekChatClient;

        String response = selectedClient.prompt(request.getMessage()).call().content();

        return new ChatResponse(response, request.getModel());
    }

    @GetMapping("/chat")
    public ChatResponse chat_get(@RequestParam ChatRequest request) {
        ChatClient selectedClient = request.getModel().equals("openai")
                ? openAiChatClient
                : deepSeekChatClient;

        String response = selectedClient.prompt(request.getMessage()).call().content();

        return new ChatResponse(response, request.getModel());
    }


}
