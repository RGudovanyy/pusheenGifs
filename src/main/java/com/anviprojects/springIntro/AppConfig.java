package com.anviprojects.springIntro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

/**
 *
 */
@SpringBootApplication
@EnableAutoConfiguration // mark this class to enable auto configuration
@ComponentScan // referred to scan the project for controllers
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    public static String ROOT = "src/main/resources/static/gifs";

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args); // добавляем возможность деплоя на сервер

    }

    /**
     *
     * @return
     */
    @Bean
    CommandLineRunner init(){
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
}
