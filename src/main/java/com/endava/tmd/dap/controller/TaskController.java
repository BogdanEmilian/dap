package com.endava.tmd.dap.controller;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;
import com.endava.tmd.dap.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(path= "/tasks/{title}/{description}/{status}/{priority}")
    public void createTask(@PathVariable String title, @PathVariable String description, @PathVariable Label status, @PathVariable Priority priority){
        taskService.saveTask(new Task(title, description, Calendar.getInstance(), status, priority));
    }

    @GetMapping(path = "/tasks")
    public List<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping(path = "/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return taskService.findTask(id);
    }

    @PutMapping(path = "/tasks/{id}/{status}")
    public void updateTask(@PathVariable int id, @PathVariable Label status){
        final Task task = taskService.findTask(id);
        task.setStatus(status);
        taskService.updateTask(task);
    }

    @DeleteMapping(path = "/tasks/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }
}
