package org.example.atmdataproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient

public class AtmdataprojectApplication {

    public static void main(String[] args) {

        SpringApplication.run(AtmdataprojectApplication.class, args);
    }

}
