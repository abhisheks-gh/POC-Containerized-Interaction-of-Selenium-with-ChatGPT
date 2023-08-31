/** Controller for handling incoming HTTP request and managing responses. */

package com.realitsolutions.demo.controller;

import com.realitsolutions.demo.model.PromptRequest;
import com.realitsolutions.demo.model.Response;
import com.realitsolutions.demo.service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatgpt")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @Autowired
    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @GetMapping("/login")
    public String loginToChatGPT() {
        chatGPTService.loginToChatGPT();
        // Return a response or redirect as needed
        return "Logged in to ChatGPT";
    }

    @PostMapping("/send-prompt")
    public Response sendPrompt(@RequestBody PromptRequest promptRequest) {
        String response = chatGPTService.sendPromptToChatGPT(promptRequest.getPrompt());
        return new Response(response);
    }

    @GetMapping("/get-prompt")
    public Response getResponse() {
        String response = chatGPTService.getResponseFromChatGPT();
        return new Response(response);
    }
}
