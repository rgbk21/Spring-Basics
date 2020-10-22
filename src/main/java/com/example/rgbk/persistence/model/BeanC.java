package com.example.rgbk.persistence.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

// Note the order of execution when BOTH destroyMethod and @PreDestroy are specified
// The @PreDestroy will be executed first. Followed by destroyMethod.
public class BeanC {

    private static Logger log = LoggerFactory.getLogger(BeanC.class);

    public BeanC() {
        log.info("In BeanC - Constructor called.");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("In BeanC - @PreDestroy annotated method is called.");
    }

    public void destroy() {
        log.info("In BeanC - Custom destroy method is called.");
    }
}
