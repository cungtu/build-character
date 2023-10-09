package com.hand.buildcharacter.dao;

import com.hand.buildcharacter.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    public List<Skill> findAllByOrderById();

}
