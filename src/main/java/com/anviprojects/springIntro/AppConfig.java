package com.anviprojects.springIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration // помечаем класс для включения автоконфигурации
@ComponentScan // указываем сканировать проект на предмет контроллеров
public class AppConfig {
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args); // добавляем возможность деплоя на сервер
    }
}
