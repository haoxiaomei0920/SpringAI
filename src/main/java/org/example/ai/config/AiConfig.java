package org.example.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AiConfig {
    private final ChatModel deepSeekChatModel;

    public AiConfig(DeepSeekChatModel deepSeekChatModel) {
        this.deepSeekChatModel = deepSeekChatModel;
//        String res = this.deepSeekChatModel.call("请问你是deepseek吗？");
//        System.out.println(res);
    }

    @Bean
    ChatClient.Builder chatClientBuilder() {
        return ChatClient.builder(this.deepSeekChatModel);
    }
    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        ChatClient chatClient = builder.build();
//        String res = chatClient.prompt("Tell me a joke").call().content();
        //System.out.println(res);
        return chatClient;
    }

    public ChatModel getDeepSeekChatModel() {
        return deepSeekChatModel;
    }
}
