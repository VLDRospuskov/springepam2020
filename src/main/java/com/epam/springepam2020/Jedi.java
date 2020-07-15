package com.epam.springepam2020;

import org.springframework.stereotype.Component;

@Component
public class Jedi {

    private Subject subject;

    public Jedi() {
    }

    public Jedi(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void getInHands() {
        System.out.println("I keep in hands nothing");
    }

}
