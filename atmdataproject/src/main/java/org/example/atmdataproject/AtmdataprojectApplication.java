package org.example.atmdataproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AtmdataprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmdataprojectApplication.class, args);
    }

}
