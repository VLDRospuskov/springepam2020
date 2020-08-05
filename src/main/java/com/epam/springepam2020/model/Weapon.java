package com.epam.springepam2020.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}
