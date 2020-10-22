package com.example.rgbk.config;

import com.example.rgbk.persistence.model.lifecycle.BeanA;
import com.example.rgbk.persistence.model.lifecycle.BeanB;
import com.example.rgbk.persistence.model.lifecycle.BeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod = "initialize")
    public BeanB beanB(){
        return new BeanB();
    }

    @Bean(destroyMethod = "destroy")
    public BeanC beanC(){
        return new BeanC();
    }

}
