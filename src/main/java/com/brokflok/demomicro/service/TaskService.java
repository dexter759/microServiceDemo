package com.brokflok.demomicro.service;

import com.brokflok.demomicro.entity.Task;
import com.brokflok.demomicro.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;


    public List<Task> findAll(){
       return taskRepository.findAll();
    }

}
