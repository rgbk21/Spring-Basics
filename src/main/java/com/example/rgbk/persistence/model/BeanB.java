package com.example.rgbk.persistence.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

// Note the order of execution when BOTH initMethod and @PostConstruct are specified
// The @PostConstruct will be executed first. Followed by initMethod.
public class BeanB {

    private static Logger log = LoggerFactory.getLogger(BeanB.class);

    public BeanB() {
        log.info("In BeanB - Constructor called.");
    }

    public void initialize() {
        log.info("In BeanB - Custom initializer is called.");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("In Bean B - @PostConstruct method is called.");
    }
}
