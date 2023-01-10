package com.api.localisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.api.localisation.*")
@AutoConfiguration(after = { DataSourceAutoConfiguration.class })
@EnableJpaRepositories("com.api.localisation.Dao")
public class LocalisationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalisationApplication.class, args);
    }

}
