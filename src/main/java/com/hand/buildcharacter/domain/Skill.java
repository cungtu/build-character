package com.hand.buildcharacter.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "SKILL")
public class Skill {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQUENCE_SKILL"
    )
    @SequenceGenerator(
            name = "SEQUENCE_SKILL",
            sequenceName = "SEQUENCE_SKILL",
            allocationSize = 0
    )
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "POINT")
    private String point;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "CHARACTER_ID")
    private Character character;

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

    public String getPoint() {
        return point;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setPoint(String point) {
        this.point = point;
    }


}
