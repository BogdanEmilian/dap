package com.endava.tmd.dap.entity;

import com.endava.tmd.dap.sha256.SHA256Controller;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String passwordHash;
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
        this.passwordHash = SHA256Controller.hash(password);
        this.email = email;
        this.taskList = taskList;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return passwordHash;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTeams(Team team){
        teamsList.add(team);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(passwordHash, user.passwordHash) && Objects.equals(email, user.email) && Objects.equals(getTaskList(), user.getTaskList()) && Objects.equals(teamsList, user.teamsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getUsername(), passwordHash, email, getTaskList(), teamsList);
    }
}
