package com.hand.buildcharacter.domain;

import jakarta.persistence.*;

@Entity
@Table(name="SKILL")
public class Skill {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "skill_generator"
    )
    @SequenceGenerator(
            name = "skill_generator",
            sequenceName = "SEQUENCE_SKILL",
            allocationSize = 10
    )
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
