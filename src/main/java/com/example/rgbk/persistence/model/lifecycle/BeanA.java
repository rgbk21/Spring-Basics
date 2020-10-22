package com.example.rgbk.persistence.model.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class BeanA {

    private static Logger log = LoggerFactory.getLogger(BeanA.class);

    public BeanA() {
        log.info("In BeanA - Constructor called.");
    }

    @PostConstruct
    public void post() {
        log.info("In BeanA - @PostConstruct annotated method is called.");
    }

}
