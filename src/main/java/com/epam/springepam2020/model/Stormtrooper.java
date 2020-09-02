package com.epam.springepam2020.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Stormtrooper {

    @Id
    @GeneratedValue
    private Integer id;

    private String login;

    private String password;

    private Byte age;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    // error
    @OneToMany(mappedBy = "stormtrooper", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public List<Address> getAddresses() {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }

        return addresses;
    }

    // AUTO
    // IDENTITY
    // t1 1 2 4 5
    // t2 1 2 3 4
    // SEQUENCE -> TABLE
    // t1 1 3 6
    // t2 2 4 5

}
