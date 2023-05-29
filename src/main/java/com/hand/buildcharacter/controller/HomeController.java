package com.hand.buildcharacter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    private String getHome()
    {
        return "home";
    }
}
