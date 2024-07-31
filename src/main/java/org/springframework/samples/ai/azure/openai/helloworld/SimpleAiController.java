package org.springframework.samples.ai.azure.openai.helloworld;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAiController {

    private final ChatClient chatClient;

    public SimpleAiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ai/simple")
    public String completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {

        return( this.chatClient
                .prompt()
                .user(message)
                .call()
                .content() );
    }
}
