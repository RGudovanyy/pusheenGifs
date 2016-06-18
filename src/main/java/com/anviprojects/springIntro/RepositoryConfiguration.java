package com.anviprojects.springIntro;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // указывает спрингу что это конфигурационный класс
@EnableAutoConfiguration // включает автоконфиг спринг бута
@EntityScan(basePackages = {"com.anviprojects.springIntro.model"}) // указываем где хибернейту смотреть entity
@EnableJpaRepositories(basePackages = {"com.anviprojects.springIntro.data"}) // включаем автоконфиг spring data jpa
@EnableTransactionManagement // подключаем управление транзакциями
public class RepositoryConfiguration {
}
