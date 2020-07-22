package com.epam.springepam2020.model;

import lombok.Data;

@Data
public class Stormtrooper {

    private String name;
    private String weapon;

    public Stormtrooper() {

    }

    public Stormtrooper(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
