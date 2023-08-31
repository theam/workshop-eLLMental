package com.theagilemonkeys.workshop;

import com.theagilemonkeys.workshop.config.EmbeddingsSpaceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EmbeddingsSpaceConfiguration.class)
public class WorkshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

}
