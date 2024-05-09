package com.ktek.todoappspringbootpractice.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired private TaskRepository repo;

    public List<Task> listAll() {
        return (List<Task>) repo.findAll();
    }

    public void save(Task task) {
        repo.save(task);
    }

    public Task get(Integer id) throws TaskNotFoundException {
        Optional<Task> result = repo.findById(id);
        if(result.isPresent()) {
            return result.get();
        }

        throw new TaskNotFoundException("Couldn't find any tasks with ID " + id);
    }

    public void delete(Integer id)  {
        repo.deleteById(id);
    }
}
