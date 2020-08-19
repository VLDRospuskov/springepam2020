package com.epam.springepam2020.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Stormtrooper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String login;

    private String password;

    private Byte age;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    // AUTO
    // IDENTITY
    // t1 1 2 4 5
    // t2 1 2 3 4
    // SEQUENCE -> TABLE
    // t1 1 3 6
    // t2 2 4 5

}
