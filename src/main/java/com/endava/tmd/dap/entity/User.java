package com.endava.tmd.dap.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String email;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "user_id")
    private List<Task> taskList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "userTeams",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> teamsList = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String email, List<Task> taskList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.taskList = taskList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
