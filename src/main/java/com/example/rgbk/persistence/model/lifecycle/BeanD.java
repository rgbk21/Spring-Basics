package com.example.rgbk.persistence.model.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class BeanD {

    private static final Logger log = LoggerFactory.getLogger(BeanD.class);
    private String foo;

    public BeanD() {
        log.info("In BeanD - Constructor called.");
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void initialize() {
        log.info("In BeanD - Custom initializer is called.");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("In Bean D - @PostConstruct method is called.");
        log.info("Value of the property foo is: {}", this.foo);
    }
}

