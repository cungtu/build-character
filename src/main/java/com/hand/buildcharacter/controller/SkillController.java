package com.hand.buildcharacter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SkillController {
    @GetMapping("/skill")
    private String getSkill()
    {
        return "skill";
    }
}
