package com.hand.buildcharacter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {
    @GetMapping("/character")
    private String getCharacter()
    {
        return "character";
    }
}
