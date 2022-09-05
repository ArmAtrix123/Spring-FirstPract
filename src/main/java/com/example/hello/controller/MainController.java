package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController{
    @GetMapping("/calc")
    public String calc(Model model) {
        return "calc";
    }
    @PostMapping("/ravno")
    public String ravno(@RequestParam(value = "firstNumber", defaultValue = "0") int a,
                           @RequestParam(value = "secondNumber", defaultValue = "0") int b,
                           @RequestParam(value = "action", defaultValue = "-") String action, Model model){
        double c;
        switch (action){
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            default:
                c = 0;
                break;
        }
        model.addAttribute("answer", c);
        return "result";
    }
}
