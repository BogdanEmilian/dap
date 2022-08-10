package com.endava.tmd.dap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.repo.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(final Task task) {
        LOGGER.info("Creating task: " + task);
        taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        LOGGER.info("Find all tasks...");
        final List<Task> tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    public Task findTask(final int id) {
        LOGGER.info("Finding task by id: " + id);
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new RuntimeException("Couldn't find task by id: " + id);
            // 500 - Internal Server Error will be returned on the client side
        }
    }

    public void updateTask(final Task task) {
        LOGGER.info("Updating task: " + task);
        taskRepository.save(task);
    }

    public void deleteTask(final int id) {
        LOGGER.info("Deleting task by id: " + id);
        taskRepository.deleteById(id);
    }
}
