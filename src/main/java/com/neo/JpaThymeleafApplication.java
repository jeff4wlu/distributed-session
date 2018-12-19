package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class JpaThymeleafApplication extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JpaThymeleafApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JpaThymeleafApplication.class, args);
    }
}

