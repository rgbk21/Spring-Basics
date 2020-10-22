package com.example.rgbk.persistence.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class PrototypeBean {

    private static Logger log = LoggerFactory.getLogger(PrototypeBean.class);

    public PrototypeBean() {
        log.info("In PrototypeBean - Constructor called");
    }

    @PostConstruct
    public void post(){
        log.info("In PrototypeBean - Returned instance of bean: {}", this);
    }

}
