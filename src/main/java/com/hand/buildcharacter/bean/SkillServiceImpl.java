package com.hand.buildcharacter.bean;

import com.hand.buildcharacter.domain.Skill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jt on 1/26/16.
 */
@Service
public class SkillServiceImpl implements SkillService {

    private Map<Integer, Skill> productMap;

    public SkillServiceImpl() {
        loadProducts();
    }

    @Override
    public Skill getSkill(Integer id) {
        return productMap.get(id);
    }

    @Override
    public List<Skill> listSkill() {
        return new ArrayList<>(productMap.values());
    }

    private void loadProducts() {
    Skill skillStrength = new Skill();
        skillStrength.setId(1L);
        skillStrength.setName("Strength");
        productMap.put(0, skillStrength);

    }
}
