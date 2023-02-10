package com.socialmedia.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChatModel {




    private Long id;


    private Long fromUser;


    private Long toUser;

    private LocalDateTime time;

    private String text;
    //hello
}
