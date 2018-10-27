package com.evolvice.config;

import com.evolvice.repository.Config.EvolviceRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.evolvice.**")
@Configuration
@Import({EvolviceRepositoryConfig.class})
public class EvolviceSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvolviceSpringBootApplication.class, args);
    }
}
