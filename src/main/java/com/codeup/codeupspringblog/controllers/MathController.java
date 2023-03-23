package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable long num1, @PathVariable long num2){
        return num1+" + "+num2 +" = "+(num1+num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable long num1, @PathVariable long num2){
        return num2+" - "+num1 +" = "+(num2-num1);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable long num1, @PathVariable long num2){
        return num1+" * "+num2 +" = "+(num1*num2);
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable long num1, @PathVariable long num2){

        if(num2 == 0){
            return "Cannot divide by zero";
        }
        return num1+" / "+num2 +" = "+(num1/num2);
    }
}

