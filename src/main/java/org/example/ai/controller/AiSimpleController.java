package org.example.ai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/ai")
public class AiSimpleController {

    Logger LOG = LoggerFactory.getLogger(AiSimpleController.class);

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
    public Flux<String> chat(@RequestBody ChatRequest request) {
        ChatClient selectedClient = request.getModel().equals("gpt-4.1")
                ? openAiChatClient
                : deepSeekChatClient;

//        String response = selectedClient.prompt(request.getMessages()).call().content();
//        System.out.println("ASSISTANT: " + response);

        try {
            // 反应式 Flux API 来流式传输响应
            Flux<String> output = selectedClient.prompt(request.getMessages())
                    .stream().content();
            return output;
        } catch (Exception e) {
            LOG.error("大模型调用异常，请检查！", e);
            return Flux.error(e);
        }



    }



}
