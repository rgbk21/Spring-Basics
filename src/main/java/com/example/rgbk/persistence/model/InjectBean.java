package com.example.rgbk.persistence.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectBean {

    @Autowired
    public SingletonBean sb1;

    @Autowired
    public SingletonBean sb2;

    @Autowired
    public PrototypeBean pb1;

    @Autowired
    public PrototypeBean pb2;

}
