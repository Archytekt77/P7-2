package com.loicmaria.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="com.loicmaria.webapp")
public class ApiProperties {

    private String apiUrl;
}
