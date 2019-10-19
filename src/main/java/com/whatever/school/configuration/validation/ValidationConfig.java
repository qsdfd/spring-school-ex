package com.whatever.school.configuration.validation;

import com.whatever.school.annotation.schoolNumber.ValidationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:validation.properties")
public class ValidationConfig {

    @Bean
    public ValidationProperties validationProperties(){
        return new ValidationProperties();
    }
}
