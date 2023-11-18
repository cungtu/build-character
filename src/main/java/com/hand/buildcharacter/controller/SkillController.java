package com.hand.buildcharacter.controller;

import java.util.List;


import com.hand.buildcharacter.domain.Character;
import com.hand.buildcharacter.domain.Skill;
import com.hand.buildcharacter.service.CharacterService;
import com.hand.buildcharacter.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/skill")
public class SkillController {

    private SkillService skillRepository;
    private CharacterService characterService;

    public SkillController(SkillService theSkillRepository, CharacterService theCharacterService) {
        skillRepository = theSkillRepository;
        characterService = theCharacterService;
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

    @GetMapping("/showFormDetail")
    public String showFormForDetail(@RequestParam("characterId") int characterId,
                                    Model theModel) {
        List<Skill> skills = skillRepository.findByCharacterId(characterId);
        for (Skill skill : skills) {
            switch (skill.getName()) {
                case "Sức mạnh" -> theModel.addAttribute("strengSkill", skill);
                case "Trí tuệ" -> theModel.addAttribute("interlligentSkill", skill);
                case "Lãnh đạo" -> theModel.addAttribute("leadershipSkill", skill);
                case "Tính cách" -> theModel.addAttribute("personalitySkill", skill);
                case "Cảm xúc" -> theModel.addAttribute("emotionalSkill", skill);
            }
        }
        Character character = characterService.findById(characterId);
//        theModel.addAttribute("skills", skills);
        theModel.addAttribute("character", character);
        return "skills/skill";
    }
}
