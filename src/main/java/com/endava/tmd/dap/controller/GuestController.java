package com.endava.tmd.dap.controller;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
public class GuestController {

    @GetMapping(path = "/")
    public List<Task> home() {
        return List.of(
                new Task(
                        "Title 1",
                        "Description 1",
                        Calendar.getInstance(),
                        Label.TODO,
                        Priority.LOW
                )
        );
    }

}