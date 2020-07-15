package com.epam.springepam2020;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        Stormtrooper stormtrooper = new Stormtrooper(new Weapon("blaster"));
        stormtrooper.getInHands();

        System.out.println("------------XML-------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Stormtrooper stormtrooperBean = (Stormtrooper) context.getBean("stormtrooper");
        stormtrooperBean.getInHands();

        System.out.println("--------XML + Annotation----------");
        Jedi jedi = context.getBean("jedi", Jedi.class);
        jedi.getInHands();
    }

}
