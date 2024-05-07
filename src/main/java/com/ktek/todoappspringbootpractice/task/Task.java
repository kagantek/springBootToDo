package com.ktek.todoappspringbootpractice.task;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer task_id;

    @Column(length = 15, nullable = false)
    private String task_type;

    @Column(length = 45, nullable = false, name = "task_name")
    private String task_name;

    @Column(length = 10, nullable = false, name = "deadline")
    private String deadline_date;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDeadline_date() {
        return deadline_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_type='" + task_type + '\'' +
                ", task_name='" + task_name + '\'' +
                ", deadline_date='" + deadline_date + '\'' +
                '}';
    }

    public void setDeadline_date(String deadline_date) {
        this.deadline_date = deadline_date;
    }
}
