package com.ktek.todoappspringbootpractice.task;

public class TaskNotFoundException extends Throwable {
    public TaskNotFoundException(String s) {
        super(s);
    }
}
