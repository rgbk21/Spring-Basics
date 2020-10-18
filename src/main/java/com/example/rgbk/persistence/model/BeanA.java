package com.example.rgbk.persistence.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class BeanA {

    private static Logger log = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void post() {
        log.info("In BeanA - @PostConstruct annotated method is called.");
    }

}
