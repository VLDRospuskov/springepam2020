package com.epam.springepam2020;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Jedi {

    private Subject subject;

//    public Jedi(@Qualifier("flag") Subject subject) {
//        this.subject = subject;
//    }

    //    public Jedi() {
//    }
//
//    public Jedi(@Qualifier("flag") Subject subject) {
//        this.subject = subject;
//    }

    public void getInHands() {
        System.out.println("I keep in hands nothing");
    }

}
