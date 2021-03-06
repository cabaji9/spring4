package com.personal.spring.controller;

import com.personal.spring.service.HelloService;
import com.personal.spring.vo.FormData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * Created by Hyun Woo Son on 1/22/18
 **/
@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Map<String,Object> model){
        logger.debug("index() executed");
        model.put("title",helloService.getSalute("HAOAALALA"));
        return "index";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        logger.debug("hello() is executed - $name {}", name);

        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("title", helloService.getSalute(name));

        return model;

    }


    @PreAuthorize("hasRole('ROLE_BATMAN') and #formData.name.length() < 3")
    @RequestMapping(value = "/button", method = RequestMethod.GET)
    public ModelAndView buttonClick(@ModelAttribute("userFormData") FormData formData) {


        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        model.addObject("timeActual", new Date());

        logger.info("CALLED LALA!: {}", formData.getName());
        return model;

    }





}
