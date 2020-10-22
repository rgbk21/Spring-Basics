package com.example.rgbk.persistence.model.beanscopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
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
