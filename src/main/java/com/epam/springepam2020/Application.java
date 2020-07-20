package com.epam.springepam2020;

import com.epam.springepam2020.annconfig.AnnotationConfig;
import com.epam.springepam2020.annconfig.Sith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        System.out.println("--------Java----------------");
        Stormtrooper stormtrooper = new Stormtrooper(new Weapon());
        stormtrooper.getInHands();

        System.out.println("------------XML-------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Stormtrooper stormtrooperBean = (Stormtrooper) context.getBean("stormtrooper");
        Stormtrooper stormtrooperBean2 = (Stormtrooper) context.getBean("stormtrooper");
        stormtrooperBean.getInHands();
        System.out.println(stormtrooperBean.getName());
        System.out.println("----------------------------------");
        System.out.println(stormtrooperBean.toString());
        stormtrooperBean.setName("White stormtropper");
        System.out.println(stormtrooperBean2.toString());
        System.out.println(stormtrooperBean.toString());
        System.out.println(stormtrooperBean == stormtrooperBean2);

        System.out.println("--------XML + Annotation----------");
        Jedi jedi = context.getBean("jedi", Jedi.class);
        jedi.getInHands();

        System.out.println("-------Java config----------------");
        ApplicationContext annContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Sith sith = annContext.getBean("sith", Sith.class);
        Sith sith2 = annContext.getBean("sith", Sith.class);
        System.out.println(sith.toString());
        System.out.println(sith == sith2);

        // GET PUT POST DELETE
        // CRUD - create read update delete
        // create(POST) read(GET) update(PUT) delete(DELETE)
        // thymeleaf jsp freemaker mustache -> thymeleaf
        // tomcat
        // postgresql
    }

}
