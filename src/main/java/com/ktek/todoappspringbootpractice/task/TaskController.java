package com.ktek.todoappspringbootpractice.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/tasks/save")
    public String saveTask(Task task) {
        service.save(task);

        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{task_id}")
    public String showEditTaskForm(@PathVariable("task_id") Integer task_id, Model model) {
        try {
            Task task = service.get(task_id);
            model.addAttribute("task", task);
            model.addAttribute("pageTitle", "Edit Task (ID: " + task_id + ")");
            return "task_form";
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            return "redirect:/tasks";
        }
    }


}
