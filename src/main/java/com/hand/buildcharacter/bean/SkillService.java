package com.hand.buildcharacter.bean;

import com.hand.buildcharacter.domain.Skill;

import java.util.List;

/**
 * Created by jt on 1/26/16.
 */
public interface SkillService {

    Skill getSkill(Integer id);

    List<Skill> listSkill();
}
