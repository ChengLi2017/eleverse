package com.eleverse.eleverse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.eleverse.eleverse.dao")
public class EleverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EleverseApplication.class, args);
    }

}
