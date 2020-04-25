package com.upgrad.videohoster.api;

import com.upgrad.videohoster.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceConfiguration.class)
public class VideoHosterApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoHosterApplication.class,args);
    }
}
