package com.endava.tmd.dap.config;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;
import com.endava.tmd.dap.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Init {

    private static final Logger LOGGER = LoggerFactory.getLogger(Init.class);

    @Autowired
    private TaskService taskService;

    @Bean
    @Profile(value="default")
    private void defaultData() {
        LOGGER.info("Initializing data, profile: default (In Progress, TO DO)");
        // some dummy input
        taskService.saveTask(new Task("To test the app", "description la la", Calendar.getInstance(), Label.INPROGRESS, Priority.MEDIUM ));
        taskService.saveTask(new Task("To run the app", "description bla bla", Calendar.getInstance(), Label.TODO, Priority.LOW ));
    }

    @Bean
    @Profile(value="dev")
    private void devData() {
        LOGGER.info("Initializing data, profile: dev (Completed)");
        // some dummy input
        taskService.saveTask(new Task("To test the app", "description la la", Calendar.getInstance(), Label.COMPLETED, Priority.MEDIUM ));
        taskService.saveTask(new Task("To run the app", "description bla bla", Calendar.getInstance(), Label.COMPLETED, Priority.HIGH ));
    }
}
