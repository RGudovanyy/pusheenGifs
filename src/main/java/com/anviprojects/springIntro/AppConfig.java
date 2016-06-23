package com.anviprojects.springIntro;

import com.anviprojects.springIntro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@EnableAutoConfiguration // помечаем класс для включения автоконфигурации
@ComponentScan // указываем сканировать проект на предмет контроллеров
public class AppConfig {
    public static String ROOT = "src/main/resources/static/gifs";

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args); // добавляем возможность деплоя на сервер
    }

    @Bean
    CommandLineRunner init(){
        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
}
