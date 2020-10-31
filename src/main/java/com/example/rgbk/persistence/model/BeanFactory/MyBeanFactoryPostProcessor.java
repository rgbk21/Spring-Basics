package com.example.rgbk.persistence.model.BeanFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;



@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public static final Logger log = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("Setting properties in BeanFactoryPostProcessor");
        BeanDefinition bd = beanFactory.getBeanDefinition("beanD");
        bd.getPropertyValues().add("foo", "bar");
        log.info("Properties set in BeanFactoryPostProcessor");
    }
}
