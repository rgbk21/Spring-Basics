package com.example.rgbk.persistence.model.BeanFactory;

import com.example.rgbk.persistence.model.lifecycle.BeanB;
import com.example.rgbk.persistence.model.lifecycle.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyBeanFactory {

//    @Bean
//    @Scope("singleton")
//    public SingletonBean singletonBean(){
//        return new SingletonBean();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public PrototypeBean prototypeBean(){
//        return new PrototypeBean();
//    }

    @Bean
    public BeanD beanD(){
        return new BeanD();
    }

}
