package com.hand.buildcharacter.controller;

import com.hand.buildcharacter.domain.Character;
import com.hand.buildcharacter.service.CharacterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/character")
public class CharacterController {

    private CharacterService characterRepository;

    public CharacterController(CharacterService repository) {
        characterRepository = repository;
    }

    @GetMapping("/list")
    public String listSkills(Model theModel) {
        List<Character> characters = characterRepository.findAll();
        theModel.addAttribute("characters", characters);
        return "characters/list-characters";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Character character = new Character();
        theModel.addAttribute("character", character);
        return "characters/character-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("characterId") int theId,
                                    Model theModel) {
        Character character = characterRepository.findById(theId);
        theModel.addAttribute("character", character);
        return "characters/character-form";
    }

    @PostMapping("/save")
    public String saveCharacter(@ModelAttribute("character") Character character) {
        characterRepository.save(character);
        return "redirect:/character/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("characterId") int theId) {
        characterRepository.deleteById(theId);
        return "redirect:/character/list";
    }
}
