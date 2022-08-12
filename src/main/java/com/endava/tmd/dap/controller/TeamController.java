package com.endava.tmd.dap.controller;

import com.endava.tmd.dap.entity.Team;
import com.endava.tmd.dap.service.TaskService;
import com.endava.tmd.dap.service.TeamService;
import com.endava.tmd.dap.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/createTeam/{name}/{ids}")
    public void createTeam(@PathVariable String name, @PathVariable List<Integer> ids){

        Team team = new Team(name);

        LOGGER.info("Creating team: " + team + " for the users: ");

        for(Integer id : ids){
            team.addUser(userService.findUser(id));
            userService.findUser(id).addTeams(team);

            LOGGER.info(id + " ");
        }


        teamService.saveTeam(team);
    }

    @GetMapping(path = "/teams")
    public List<Team> getTeams(){
        return teamService.findAllTeams();
    }

    @GetMapping(path = "/team/{id}")
    public Team getTeam(@PathVariable int id){
        return teamService.findTeam(id);
    }

    @PutMapping(path = "/team/{teamId}/{userId}")
    public void editTeam(@PathVariable int teamId, @PathVariable int userId){

        if(teamService.userExists(teamId, userId))
        {
            //Removes the user if he exists
            LOGGER.info("User with id: " + userId + " exists. Deleting the user from the team");
            teamService.findTeam(teamId).removeUser(userService.findUser(userId));
        }
        else
        {
            //Adds the user if he does not exist
            LOGGER.info("User with id: " + userId + " doesn't exist. Adding the new user to the team");
            teamService.findTeam(teamId).addUser(userService.findUser(userId));
        }
    }

    @DeleteMapping(path = "/removeTeam/{id}")
    public void deleteTeam(@PathVariable int id){

        LOGGER.info("Deleting team with id: " + id);
        teamService.deleteTeam(id);
    }
}