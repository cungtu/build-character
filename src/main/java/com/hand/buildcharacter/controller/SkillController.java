package com.hand.buildcharacter.controller;

import java.util.List;


import com.hand.buildcharacter.domain.Skill;
import com.hand.buildcharacter.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/skill")
public class SkillController {

    private SkillService skillRepository;

    public SkillController(SkillService theSkillRepository) {
        skillRepository = theSkillRepository;
    }

    @GetMapping("/list")
    public String listSkills(Model theModel) {
        List<Skill> theSkills = skillRepository.findAll();
        theModel.addAttribute("skills", theSkills);
        return "skills/list-skills";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Skill theSkill = new Skill();
        theModel.addAttribute("skill", theSkill);
        return "skills/skill-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("skillId") int theId,
                                    Model theModel) {
        Skill theSill = skillRepository.findById(theId);
        theModel.addAttribute("skill", theSill);
        return "skills/skill-form";
    }

    @PostMapping("/save")
    public String saveSkill(@ModelAttribute("skill") Skill theSkill) {
        skillRepository.save(theSkill);
        return "redirect:/skill/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("skillId") int theId) {
        skillRepository.deleteById(theId);
        return "redirect:/skill/list";
    }
}
