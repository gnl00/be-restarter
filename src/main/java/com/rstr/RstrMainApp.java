package com.rstr;

import com.rstr.cus.CusRestarApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RstrMainApp {
    public static void main(String[] args) {
        System.out.println("RstrMainApp classloader: " + RstrMainApp.class.getClassLoader());
        SpringApplication springApplication = new SpringApplication();
        // add custom application listener
        // springApplication.addListeners(new CusRestarApplicationListener());
        springApplication.addPrimarySources(List.of(RstrMainApp.class));
        springApplication.run(args);
    }
}
