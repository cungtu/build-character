package com.hand.buildcharacter.service;

import com.hand.buildcharacter.dao.CharacterRepository;
import com.hand.buildcharacter.dao.SkillRepository;
import com.hand.buildcharacter.domain.Character;
import com.hand.buildcharacter.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class CharacterServiceImpl implements CharacterService{

    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository) {
        characterRepository = repository;
    }


    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character findById(int theId) {
        Optional<Character> result = characterRepository.findById(theId);
        Character character = null;
        if (result.isPresent()) {
            character = result.get();
        }
        else {
            throw new RuntimeException("Did not find Character id - " + theId);
        }
        return character;
    }

    @Override
    public void save(Character character) {
        characterRepository.save(character);
    }

    @Override
    public void deleteById(int theId) {
        characterRepository.deleteById(theId);
    }
}
