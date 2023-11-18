package com.hand.buildcharacter.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CHARACTER")
public class Character {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQUENCE_CHARACTER"
    )
    @SequenceGenerator(
            name = "SEQUENCE_CHARACTER",
            sequenceName = "SEQUENCE_CHARACTER",
            allocationSize = 0
    )
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @OneToMany(mappedBy = "character",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Skill> Skills ;

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

    public List<Skill> getSkills() {
        return Skills;
    }

    public void setSkills(List<Skill> skills) {
        Skills = skills;
    }
}
