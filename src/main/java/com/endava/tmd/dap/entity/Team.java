package com.endava.tmd.dap.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "teamsList")
    private List<User> usersList = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public Team(){
    }

    public void addUser(User user){
        usersList.add(user);
    }

    public List<User> listOfUsers(){
        return usersList;
    }

    public void removeUser(User user){
        usersList.remove(user);
    }
}
