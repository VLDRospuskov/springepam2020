package com.epam.springepam2020.annconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.epam.springepam2020.annconfig")
public class AnnotationConfig {

    @Bean("sith")
    @Scope("prototype")
    public Sith getSith() {
        Sith sith = new Sith();
        sith.setName("Sith");
        sith.setShip(getShip());
        sith.setSaber(getSaber());
        return sith;
    }

    @Bean("ship")
    public Ship getShip() {
        Ship ship = new Ship();
        ship.setName("destroyer");
        return ship;
    }

    @Bean
    public Saber getSaber() {
        Saber saber = new Saber();
        saber.setName("red saber");
        return saber;
    }

}
