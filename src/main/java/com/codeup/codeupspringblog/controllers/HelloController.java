package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello, "+name;
    }

    @GetMapping("/dice-old")
    @ResponseBody
    public String rollDice(){
        int diceRoll = (int) (Math.random()*6)+1;
        return "Value is: " +diceRoll;
    }
}
