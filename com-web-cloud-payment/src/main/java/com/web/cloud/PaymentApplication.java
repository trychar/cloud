package com.web.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.web.cloud.mapper")
public class PaymentApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(PaymentApplication.class,args);
    }
}