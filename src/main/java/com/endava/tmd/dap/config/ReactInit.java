package com.endava.tmd.dap.config;

import com.endava.tmd.dap.entity.User;
import com.endava.tmd.dap.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class ReactInit implements CommandLineRunner {

    UserRepository userRepository;
    @Override
    public void run(String... strings){
        Stream.of("as","asd","ssa").forEach(name -> userRepository.save(new User("asd", "dsa", "asd@google.com", null)));
    }
}
