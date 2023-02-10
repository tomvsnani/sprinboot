package com.socialmedia.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


//@FeignClient(value = "chat",url = "http://localhost:8081/chats")
public interface FeinClientForChat {

    @GetMapping("/get/{user1}/{user2}")
    List<ChatModel> getChats(@PathVariable(value = "user1") Long user1, @PathVariable(value = "user2") Long user2);
}
