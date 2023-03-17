package com.example.emall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.emall"})
@EnableJpaAuditing
public class EmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmallApplication.class, args);
    }

}
