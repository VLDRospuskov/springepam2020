package com.epam.springepam2020;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Weapon implements Subject {

    @Value("blaster")
    private String name;

//    public Weapon(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSubject() {
        return name;
    }
}
