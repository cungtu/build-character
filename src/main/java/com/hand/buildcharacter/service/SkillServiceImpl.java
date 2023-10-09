package com.hand.buildcharacter.service;

import com.hand.buildcharacter.dao.SkillRepository;
import com.hand.buildcharacter.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository theskillRepository) {
        skillRepository = theskillRepository;
    }


    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Skill findById(int theId) {
        Optional<Skill> result = skillRepository.findById(theId);
        Skill theSkill = null;
        if (result.isPresent()) {
            theSkill = result.get();
        }
        else {
            throw new RuntimeException("Did not find Skill id - " + theId);
        }
        return theSkill;
    }

    @Override
    public void save(Skill theSkill) {
        skillRepository.save(theSkill);
    }

    @Override
    public void deleteById(int theId) {
        skillRepository.deleteById(theId);
    }
}
