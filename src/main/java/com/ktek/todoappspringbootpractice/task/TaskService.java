package com.ktek.todoappspringbootpractice.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired private TaskRepository repo;

    public List<Task> listAll() {
        return (List<Task>) repo.findAll();
    }

    public void save(Task task) {
        repo.save(task);
    }
}
