package com.shiva.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@ConfigurationProperties("classpath:application.properties")
@EnableJpaRepositories(basePackages = {
        "com.shiva.sample.domain"
})
@EntityScan(basePackages = "com.shiva.sample.domain")
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
