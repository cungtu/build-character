package com.hand.buildcharacter.dao;

import com.hand.buildcharacter.domain.Character;
import com.hand.buildcharacter.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    public List<Skill> findAllByOrderById();

}
