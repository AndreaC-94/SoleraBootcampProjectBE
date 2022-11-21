package com.solera.configuration;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration

@EnableWebMvc

public class CorsConfiguration implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry corsRegistry) {

        corsRegistry.addMapping("/**")

                .allowedMethods("GET", "POST", "PUT", "DELETE");

	}

}
