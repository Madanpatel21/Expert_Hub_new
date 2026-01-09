package com.Expert_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("Repository")
@EntityScan("entity")
@ComponentScan({
    "controller",
    "service",
    "Repository",
    "entity",
    "dto",
    "exception",
    "config"
})
public class Expert_hub {

	public static void main(String[] args) {
		SpringApplication.run(Expert_hub.class, args);
	}

}
