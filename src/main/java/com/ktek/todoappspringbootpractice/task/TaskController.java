package com.ktek.todoappspringbootpractice.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController{
    @Autowired private TaskService service;

    @GetMapping("/tasks")
    public String showTaskList(Model model) {
        List<Task> listTasks = service.listAll();
        model.addAttribute("listTasks", listTasks);

        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }
}
