package com.endava.tmd.dap.service;

import com.endava.tmd.dap.entity.Task;
import com.endava.tmd.dap.entity.Team;
import com.endava.tmd.dap.entity.User;
import com.endava.tmd.dap.enumeration.Label;
import com.endava.tmd.dap.enumeration.Priority;
import com.endava.tmd.dap.sha256.SHA256Controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServicesTest
{
    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;

    Task task1, task2, task3;
    User user1, user2;
    Team team1;

    @DisplayName("Empty list of users in team Constructor")
    @Test
    @Order(1)
    void emptyListOfUsers()
    {
        List<User> listOfUsers = new ArrayList<User>();
        team1 = new Team("Team1");

        assertEquals(team1.listOfUsers(), listOfUsers);
    }

    @DisplayName("Password hash matches")
    @Test
    @Order(2)
    void userPassword()
    {
        user1 = new User("Username 1", "Password1", "email1@endava.com", null);

        assertEquals(user1.getPassword(), SHA256Controller.hash("Password1"));
    }

    @DisplayName("List of tasks is not null")
    @Test
    @Order(3)
    void setData()
    {
        List<Task> listOfTasks = new ArrayList<>();

        task1 = new Task("Title 1", "Description 1", Calendar.getInstance(), Label.TODO, Priority.LOW);
        task2 = new Task("Title 2", "Description 2", Calendar.getInstance(), Label.INPROGRESS, Priority.MEDIUM);
        task3 = new Task("Title 3", "Description 3", Calendar.getInstance(), Label.COMPLETED, Priority.HIGH);

        listOfTasks.add(task1);
        listOfTasks.add(task2);
        listOfTasks.add(task3);

        assertEquals(listOfTasks.size(), 3);
    }

    @DisplayName("Tasks are created and deleted")
    @Test
    @Order(4)
    void deleteTasks()
    {
        List<Task> listOfTasks = new ArrayList<Task>();

        task1 = new Task("Title 1", "Description 1", Calendar.getInstance(), Label.TODO, Priority.LOW);
        task2 = new Task("Title 2", "Description 2", Calendar.getInstance(), Label.INPROGRESS, Priority.MEDIUM);
        task3 = new Task("Title 3", "Description 3", Calendar.getInstance(), Label.COMPLETED, Priority.HIGH);

        listOfTasks.add(task1);
        listOfTasks.add(task2);
        listOfTasks.add(task3);

        listOfTasks.remove(task1);
        listOfTasks.remove(task2);
        listOfTasks.remove(task3);

        assertEquals(listOfTasks, new ArrayList<Task>());
    }

    @DisplayName("Team has 2 users")
    @Test
    @Order(5)
    void teamInit()
    {
        List<Task> listOfTasks = new ArrayList<>();

        task1 = new Task("Title 1", "Description 1", Calendar.getInstance(), Label.TODO, Priority.LOW);
        task2 = new Task("Title 2", "Description 2", Calendar.getInstance(), Label.INPROGRESS, Priority.MEDIUM);
        task3 = new Task("Title 3", "Description 3", Calendar.getInstance(), Label.COMPLETED, Priority.HIGH);

        listOfTasks.add(task1);
        listOfTasks.add(task2);
        listOfTasks.add(task3);

        user1 = new User("Username 1", "Password1", "email1@endava.com", null);
        user1 = new User("Username 1", "Password1", "email1@endava.com", listOfTasks);

        team1 = new Team("Team1");
        team1.addUser(user1);
        team1.addUser(user2);

        assertEquals(team1.listOfUsers().size(), 2);
    }

    @DisplayName("Team delete users")
    @Test
    @Order(6)
    void teamDelete()
    {
        List<Task> listOfTasks = new ArrayList<>();

        task1 = new Task("Title 1", "Description 1", Calendar.getInstance(), Label.TODO, Priority.LOW);
        task2 = new Task("Title 2", "Description 2", Calendar.getInstance(), Label.INPROGRESS, Priority.MEDIUM);
        task3 = new Task("Title 3", "Description 3", Calendar.getInstance(), Label.COMPLETED, Priority.HIGH);

        listOfTasks.add(task1);
        listOfTasks.add(task2);
        listOfTasks.add(task3);

        user1 = new User("Username 1", "Password1", "email1@endava.com", null);
        user1 = new User("Username 1", "Password1", "email1@endava.com", listOfTasks);

        team1 = new Team("Team1");
        team1.addUser(user1);
        team1.addUser(user2);

        team1.removeUser(user1);
        team1.removeUser(user2);

        assertEquals(team1.listOfUsers(), new ArrayList<User>());
    }
}
