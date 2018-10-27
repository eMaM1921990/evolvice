package com.evolvice.repository.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.evolvice.repository.**")
@EntityScan(basePackages = "com.evolvice.repository.entity.**")
public class EvolviceRepositoryConfig {
}
