package com.ktek.todoappspringbootpractice;

import com.ktek.todoappspringbootpractice.task.Task;
import com.ktek.todoappspringbootpractice.task.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class TaskRepositoryTests {
    @Autowired private TaskRepository repo;

    @Test
    public void testAddNew() {
        Task task = new Task();
        task.setTask_name("CSE348 Assignment");
        task.setTask_type("Academic");
        task.setDeadline_date("2024-07-30");

        Task savedTask = repo.save(task);

        Assertions.assertThat(savedTask).isNotNull();
    }

    @Test
    public void testListAll() {
        Iterable<Task> allTasks = repo.findAll();

        Assertions.assertThat(allTasks).hasSizeGreaterThan(0);

        for(Task task_: allTasks) {
            System.out.println(task_);
        }
    }

    @Test
    public void testUpdate() {
        Integer taskId = 1;

        Optional<Task> optionalTask = repo.findById(taskId);
        Task task_ = optionalTask.get();
        task_.setTask_name("CSE348 Project");
        repo.save(task_);

        Task updatedTask = repo.findById(taskId).get();

        Assertions.assertThat(updatedTask.getTask_name()).isEqualTo("CSE348 Project");
    }

    @Test
    public void testGet() {
        Integer taskId = 1;

        Optional<Task> optionalTask = repo.findById(taskId);
        Assertions.assertThat(optionalTask).isPresent();
        System.out.println(optionalTask.get());
    }

    @Test
    public void testDelete() {
        Integer taskId = 1;
        repo.deleteById(taskId);

        Optional<Task> optionalTask = repo.findById(taskId);
        Assertions.assertThat(optionalTask).isNotPresent();
    }
}
