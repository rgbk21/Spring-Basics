package com.example.rgbk.persistence.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GenerateBean {

    @Bean
    @Scope("singleton")
    public SingletonBean singletonBean(){
        return new SingletonBean();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean prototypeBean(){
        return new PrototypeBean();
    }

}
