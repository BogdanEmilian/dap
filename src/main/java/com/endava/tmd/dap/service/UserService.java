package com.endava.tmd.dap.service;

import com.endava.tmd.dap.entity.User;
import com.endava.tmd.dap.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void addUser(final User user){
        LOGGER.info("Creating user: " + user);
    }

    public List<User> findAllUsers(){
        LOGGER.info("Finding all users...");
        final List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user -> users.add(user));
        return users;
    }

    public User findUser(final int id){
        LOGGER.info("Finding user by id: " + id);
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
        {
            return user.get();
        }
        else
        {
            throw new RuntimeException("Could not find any user with the id: " + id);
        }
    }

    public void updateUser(final User user){
        LOGGER.info("Updating user: " + user);
        userRepository.save(user);
    }

    public void deleteUser(final int id){
        LOGGER.info("Deleting user with id: " + id);
        userRepository.deleteById(id);
    }

}
