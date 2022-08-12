package com.endava.tmd.dap.controller;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;
import com.endava.tmd.dap.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskService taskService;

    //Create a new Task
    @PostMapping(path= "/createTask/{title}/{description}/{status}/{priority}")
    public void createTask(@PathVariable String title, @PathVariable String description, @PathVariable Label status, @PathVariable Priority priority)
    {
        LOGGER.info("Creating a new task: " + title + description + Calendar.getInstance() + status + priority);

        taskService.saveTask(new Task(title, description, Calendar.getInstance(), status, priority));
    }

    //Get all tasks
    @GetMapping(path = "/tasks")
    public List<Task> getTasks()
    {
        return taskService.findAllTasks();
    }

    //Get task by id
    @GetMapping(path = "/task/{id}")
    public Task getTask(@PathVariable int id)
    {
        return taskService.findTask(id);
    }

    //Edit task
    @PutMapping(path = "/task/{id}/{status}")
    public void updateTask(@PathVariable int id, @PathVariable Label status)
    {
        final Task task = taskService.findTask(id);
        task.setStatus(status);

        LOGGER.info("Updating task status to: " + status);
        taskService.updateTask(task);
    }

    //Remove task
    @DeleteMapping(path = "/removeTask/{id}")
    public void deleteTask(@PathVariable int id)
    {
        LOGGER.info("Deleting task with the id: " + id);

        taskService.deleteTask(id);
    }
}
