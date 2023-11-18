package com.hand.buildcharacter.service;


import com.hand.buildcharacter.domain.Character;

import java.util.List;

public interface CharacterService {

    List<Character> findAll();

    Character findById(int theId);

    void save(Character character);

    void deleteById(int theId);

}
