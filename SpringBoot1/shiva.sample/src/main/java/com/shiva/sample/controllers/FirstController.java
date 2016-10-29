package com.shiva.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

@Autowired Environment env;
	
	@RequestMapping("/")
    String home() {
		System.out.println("spring.jmx.enabled "+env.getProperty("spring.jmx.enabled"));
        return "Hello World!"+env.getProperty("app.name");
    }
}
