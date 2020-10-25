package com.example.rgbk.config;

import com.example.rgbk.persistence.model.lifecycle.BeanA;
import com.example.rgbk.persistence.model.lifecycle.BeanB;
import com.example.rgbk.persistence.model.lifecycle.BeanC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private Environment environment;

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

    // Lifecycle method annotation requires a no-arg method.
    // So this is an error:
    /*
    @PostConstruct
    private void readPropertyValues(Environment environment){
        LOG.info("project.prefix: {}" + environment.getProperty("project.prefix"));
    }
    */

    @PostConstruct
    private void readPropertyValues(){
        LOG.info("project.prefix: {}", environment.getProperty("project.prefix"));
    }
}
