package com.hand.buildcharacter.controller;

import com.hand.buildcharacter.bean.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkillController {

    private SkillService skillService;

    @Autowired
    public void setProductService(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skill")
    private String getSkill()
    {
        return "skill";
    }

    @RequestMapping("/skill/{id}")
    public String getSkillById(@RequestParam Integer id, Model model){

        model.addAttribute("skill", skillService.getSkill(id));

        return "skill";
    }
}
