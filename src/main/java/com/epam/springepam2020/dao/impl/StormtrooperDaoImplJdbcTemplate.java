package com.epam.springepam2020.dao.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("StormtrooperDaoImplJdbcTemplate")
public class StormtrooperDaoImplJdbcTemplate implements StormtrooperDao  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ALL_STORMTROOPERS = "SELECT stormtrooper.stormtrooper_id, stormtrooper_name, age, weapon_name FROM stormtrooper LEFT JOIN weapon ON\n" +
            "stormtrooper.stormtrooper_id = weapon.stormtrooper_id";

    public List<Stormtrooper> getAll() {
        return jdbcTemplate.query(GET_ALL_STORMTROOPERS, (resultSet, rowNum) -> {
            Weapon weapon = new Weapon();
            weapon.setName(resultSet.getString("weapon_name"));

            Stormtrooper stormtrooper = new Stormtrooper();
            stormtrooper.setId(resultSet.getInt("stormtrooper_id"));
            stormtrooper.setName(resultSet.getString("stormtrooper_name"));
            stormtrooper.setAge(resultSet.getByte("age"));
            stormtrooper.setWeapon(weapon);

            return stormtrooper;
        });
    }

    @Override
    public void save(Stormtrooper stormtrooper) {

    }

    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM stormtrooper WHERE stormtrooper_id = ?", id);
    }

}
