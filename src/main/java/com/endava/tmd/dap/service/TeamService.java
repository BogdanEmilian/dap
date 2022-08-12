package com.endava.tmd.dap.service;

import com.endava.tmd.dap.entity.Team;
import com.endava.tmd.dap.entity.User;
import com.endava.tmd.dap.repo.TeamRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    public void saveTeam(final Team team)
    {
        LOGGER.info("Creating team: " + team);

        teamRepository.save(team);
    }

    public List<Team> findAllTeams()
    {
        LOGGER.info("Find all teams...");

        final List<Team> teams = new ArrayList<Team>();

        teamRepository.findAll().forEach(team -> teams.add(team));

        return teams;
    }

    public Team findTeam(final int id)
    {
        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent())
        {
            return team.get();
        }
        else
        {
            throw new RuntimeException("Couldn't find team by id: " + id);
        }
    }

    public boolean userExists(final int teamId, final int userId)
    {
        LOGGER.info("Updating team: " + findTeam(teamId));

        for (User user : findTeam(teamId).listOfUsers()) {
            if(userService.findUser(userId).equals(user))
                return true;
        }

        return false;
    }

    public void deleteTeam(final int id)
    {
        LOGGER.info("Deleting team by id: " + id);

        teamRepository.deleteById(id);
    }
}
