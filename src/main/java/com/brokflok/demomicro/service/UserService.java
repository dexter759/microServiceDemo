package com.brokflok.demomicro.service;

import com.brokflok.demomicro.entity.Task;
import com.brokflok.demomicro.repository.TaskRepository;
import com.brokflok.demomicro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public List<Task> findAll(){
       return userRepository.findAll();
    }

}
