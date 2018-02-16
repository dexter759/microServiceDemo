package com.brokflok.demomicro.controller;


import com.brokflok.demomicro.entity.Task;
import com.brokflok.demomicro.entity.User;

import com.brokflok.demomicro.kafka.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/kafkaTest")
public class TaskController {
    private static final String HELLOWORLD_TOPIC = "bar.t";
    private static final String USER_TOPIC = "foo.t";
    private static final String SENDER_TOPIC ="send.t";
    private static final String BACKER_TOPIC ="back.t";
    @Autowired
    Sender sender;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTask(@RequestBody Task task){
        sender.send(HELLOWORLD_TOPIC,task);
    }

    @RequestMapping (path = "/user",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertUser(@RequestBody User user){
        sender.send(USER_TOPIC,user);
    }

    @RequestMapping (path = "/task",method = RequestMethod.GET)
    public void getTask(){
        sender.send(SENDER_TOPIC,new Task("Opis",true));
    }
    @RequestMapping (path = "/users",method = RequestMethod.GET)
    public void getUser(){
        sender.send(BACKER_TOPIC,new Task("Opis",true));
    }


}
