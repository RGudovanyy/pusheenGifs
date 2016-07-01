package com.anviprojects.springIntro;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration class to setting up connections with persistance level.
 * <p>Annotation {@code Configuration} tells to Spring Framework on that class as a configuration
 * Annotation {@code EnableAutoConfiguration} enables auto configuration Spring Boot
 * With annotation {@code EntityScan} system tells to Hibernate are located Entities
 * Annotation {@code EnableJPARepositories} enables auto configuration Spring Data JPA
 * Annotation {@code EnableTransactionManagement} connect mechanism of transactional management<p/>
 *
 * @author Roman Gudovanyy
 * @version 1.0
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.anviprojects.springIntro.model"})
@EnableJpaRepositories(basePackages = {"com.anviprojects.springIntro.data"})
@EnableTransactionManagement // подключаем управление транзакциями
public class RepositoryConfiguration {
}
