package com.example.websocketdemo.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.websocketdemo.model.Message;

@Component
public class TimeSender {
	
	 private Logger logger = LogManager.getLogger(TimeSender.class);
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    @Autowired
    private SimpMessagingTemplate broker;

    @Autowired
    public TimeSender(final SimpMessagingTemplate broker) {
        this.broker = broker;
    }

    @Scheduled(fixedRate = 5000)
    public void run() {
        String time = LocalTime.now().format(TIME_FORMAT);
        int i=0;
        
        logger.info("Time broadcast: {}", time);
        Message message=new Message();
        message.setSender("User sending data");
        message.setContent("sending data "+i);
        i+=1;
        message.setNumber("number");
        broker.convertAndSend("/receive/public", message);
    }
}

