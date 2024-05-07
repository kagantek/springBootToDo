package com.ktek.todoappspringbootpractice.user;


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

}
