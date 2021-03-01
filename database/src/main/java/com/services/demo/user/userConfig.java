package com.services.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class userConfig {
    @Bean
    CommandLineRunner commandLineRunner(userRepository repository){
        return args -> {
            User first = new User(
                    LocalDate.of(2020,1,12),
                    "first"
            );
            repository.saveAll(
                    List.of(first)
            );
        };
    }
}
