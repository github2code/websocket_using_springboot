package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


/**
 * Created by Vignesh on 27/03/20.
 */
@Controller
public class MessageController {

    @MessageMapping("/data")
    @SendTo("/receive/public")
    public Message sendMessage(@Payload Message message) {  
    	message.setContent("Samplecontent");
    	message.setNumber("number");
    	message.setSender("it's me");
        return message;   
        }



}
