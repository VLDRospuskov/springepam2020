package com.epam.springepam2020.util;

import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.model.Weapon;

import java.util.Random;

public class EntityGenerator {

    private static Random random = new Random();

    public static Stormtrooper generateStormtrooper() {
        return Stormtrooper.builder()
                .login("Login" + random.nextInt())
                .password("password")
                .age((byte) 10)
                .weapon(generateWeapon())
                .build();
    }

    public static Weapon generateWeapon() {
        return Weapon.builder()
                .name("weaponname")
                .build();
    }

}
