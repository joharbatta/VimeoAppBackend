package com.upgrad.videohoster.service;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.upgrad.videohoster.service")
@EntityScan("com.upgrad.videohoster.service.entity")
public class ServiceConfiguration {
}
