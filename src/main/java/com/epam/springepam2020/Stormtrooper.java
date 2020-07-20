package com.epam.springepam2020;

public class Stormtrooper {

    private String name;
    private Subject subject;

    public Stormtrooper() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stormtrooper(Subject subject) {
        this.subject = subject;
    }

    public void getInHands() {
        System.out.println("I keep in hands " + subject.getSubject());
    }

    @Override
    public String toString() {
        return "Stormtrooper{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
