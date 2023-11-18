package com.hand.buildcharacter.service;

import com.hand.buildcharacter.domain.Skill;

import java.util.List;

public interface SkillService {

    List<Skill> findAll();

    Skill findById(int theId);
    List<Skill> findByCharacterId(int characterId);

    void save(Skill theSkill);

    void deleteById(int theId);

}
