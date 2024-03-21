package com.ap.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: SpringBootApplication
 * description:
 * author: 
 * date: 2024年3月21日
 **/
@SpringBootApplication//@EnableAutoConfiguration @ComponentScan
public class OneDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(OneDemoApplication.class, args);
    }
}