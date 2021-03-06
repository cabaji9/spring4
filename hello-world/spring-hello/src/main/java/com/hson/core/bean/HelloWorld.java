package com.hson.core.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Hyun Woo Son on 11/9/17.
 */
public class HelloWorld {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        logger.info("Hola mundo a : " + this.name);
    }
}
