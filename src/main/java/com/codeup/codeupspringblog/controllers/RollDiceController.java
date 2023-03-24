package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String diceHome(){
        return "dice";
    }

    @GetMapping("/roll-dice/{val}")
    public String diceRoll(@PathVariable int val, Model model){
        model.addAttribute("targetVal", (int) (Math.random()*6)+1);
        model.addAttribute("val", val);
        return "dice";
    }
}
