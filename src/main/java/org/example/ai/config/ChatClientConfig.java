package org.example.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

//    private final ChatModel deepSeekChatModel;
//    @Bean
//    ChatClient chatClient(ChatClient.Builder builder) {
//        ChatClient chatClient = builder.build();
//        String res = chatClient.prompt("Tell me a joke").call().content();
//        //System.out.println(res);
//        return chatClient;
//    }
    @Bean
    @Qualifier("openAiChatClient")
    public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
        return ChatClient.create(chatModel);
    }


    @Bean
    @Qualifier("deepSeekChatClient")
    public ChatClient deepSeekChatClient(DeepSeekChatModel  chatModel) {
        return ChatClient.create(chatModel);
    }

//    public ChatClientConfig(DeepSeekChatModel deepSeekChatModel) {
//        this.deepSeekChatModel = deepSeekChatModel;
////        String res = this.deepSeekChatModel.call("请问你是deepseek吗？");
////        System.out.println(res);
//    }
//    @Bean
//    ChatClient.Builder chatClientBuilder() {
//        return ChatClient.builder(deepSeekChatModel);
//    }

}
