package com.endava.tmd.dap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController
{
    //Default page
    @GetMapping(path = "/")
    public String home()
    {
        return "Hello there, this is the guest page!";
    }
}

/*                                      Requests
-->Create a new task      -   http://localhost:8080/createTask/{title}/{description}/{status}/{priority}
-->Create a new user      -   http://localhost:8080/createUser/{username}/{password}/{email}
-->Create a new team      -   http://localhost:8080/createTeam/{name}/{ids}

-->Edit a task            -   http://localhost:8080/task/{id}/{status}
-->Edit a team            -   http://localhost:8080/team/{teamId}/{userId}

-->Get all tasks          -   http://localhost:8080/tasks
-->Get specific task      -   http://localhost:8080/task/{id}
-->Get all users          -   http://localhost:8080/users
-->Get specific user      -   http://localhost:8080/user/{id}
-->Get all teams          -   http://localhost:8080/teams
-->Get specific team      -   http://localhost:8080/team/{id}

-->Delete a task          -   http://localhost:8080/removeTask/{id}
-->Delete a user          -   http://localhost:8080/user/{id}
-->Delete a team          -   http://localhost:8080/removeTeam/{id}




Examples:

http://localhost:8080/createUser/username1/password1/email1
http://localhost:8080/createUser/username2/password2/email2
http://localhost:8080/createUser/username3/password3/email3

http://localhost:8080/createTeam/teamName1/1, 2, 3
 */