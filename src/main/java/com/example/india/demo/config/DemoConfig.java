package com.example.india.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties("demo-config")
@PropertySource("classpath:demo-config.properties")
public class DemoConfig {

    private String url;
    private Boolean ipEnabled;
    private String countryName;
}
