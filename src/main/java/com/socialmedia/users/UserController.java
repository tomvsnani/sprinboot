package com.socialmedia.users;

import io.micrometer.observation.annotation.Observed;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    FeinClientForChat feinClientForChat;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody UserModel userModel) {

        UserModel userModel1 = userRepository.save(userModel);

        return ResponseEntity.ok(userModel1);


    }

    @GetMapping("getChats/{user1}/{user2}")
    public List<ChatModel> getChats(@PathVariable Long user1,@PathVariable Long user2) throws Exception {

        UserModel userModel = new UserModel();
        userModel.setIt(user1);

       if(userRepository.findOne(Example.of(userModel)).isEmpty())
           throw new Exception("User one not found");

        UserModel userModel1 = new UserModel();
        userModel1.setIt(user2);

        if(userRepository.findOne(Example.of(userModel1)).isEmpty())
            throw new Exception("User two not found");

      ResponseEntity<List> chatModelList=  restTemplate.getForEntity("http://CHAT/chats/get/"+user1+"/"+user2,List.class);

        return chatModelList.getBody();
    }


    @GetMapping("/get")
    public ResponseEntity<Object> getAllUsers() {

        logger.info("in get user");


        List<UserModel> userModel1 = userRepository.findAll();

        return ResponseEntity.ok(userModel1);


    }
}
