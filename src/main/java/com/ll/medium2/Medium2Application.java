package com.ll.medium2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Medium2Application {

    public static void main(String[] args) {
        SpringApplication.run(Medium2Application.class, args);
    }

}
