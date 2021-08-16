package com.example.core_sesa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.core_sesa.Entity"})
@EnableJpaRepositories(basePackages = {"com.example.core_sesa.Repository"})
public class CoreSesaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreSesaApplication.class, args);
    }

}
