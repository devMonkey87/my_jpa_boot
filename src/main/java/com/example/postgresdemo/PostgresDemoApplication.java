package com.example.postgresdemo;

import com.example.postgresdemo.properties.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
        FileProperties.class
})
public class PostgresDemoApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(PostgresDemoApplication.class, args);
    }

}
