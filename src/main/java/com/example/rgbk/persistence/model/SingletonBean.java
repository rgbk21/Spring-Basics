package com.example.rgbk.persistence.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("singleton")
public class SingletonBean {

    private static Logger log = LoggerFactory.getLogger(SingletonBean.class);

    public SingletonBean() {
        log.info("In SingletonBean - Constructor called");
    }

    @PostConstruct
    public void post(){
        log.info("In SingletonBean - Returned instance of bean: {}", this);
    }
}
