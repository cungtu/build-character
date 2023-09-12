package com.hand.buildcharacter.domain;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//@Entity
public class Skill {
//    @Id
    Long id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
