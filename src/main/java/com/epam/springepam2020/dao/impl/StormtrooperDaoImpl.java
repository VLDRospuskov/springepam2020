package com.epam.springepam2020.dao.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.model.Stormtrooper;
import com.epam.springepam2020.model.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StormtrooperDaoImpl implements StormtrooperDao {

    private static final String GET_ALL_STORMTROOPERS = "SELECT stormtrooper.stormtrooper_id, stormtrooper_name, age, weapon_name FROM stormtrooper LEFT JOIN weapon ON\n" +
            "stormtrooper.stormtrooper_id = weapon.stormtrooper_id";

    @Autowired
    private Connection connection;

    @Override
    public List<Stormtrooper> getAll() {
        List<Stormtrooper> stormtroopers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_STORMTROOPERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Weapon weapon = new Weapon();
                weapon.setName(resultSet.getString("weapon_name"));

                Stormtrooper stormtrooper = new Stormtrooper();
                stormtrooper.setId(resultSet.getInt("stormtrooper_id"));
                stormtrooper.setName(resultSet.getString("stormtrooper_name"));
                stormtrooper.setAge(resultSet.getByte("age"));
                stormtrooper.setWeapon(weapon);
                stormtroopers.add(stormtrooper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stormtroopers;
    }

    @Override
    public void save(Stormtrooper stormtrooper) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(
                            "INSERT INTO stormtrooper (stormtrooper_name, age) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            statement.setString(1, stormtrooper.getName());
            statement.setByte(2, stormtrooper.getAge());
            int changedRows = statement.executeUpdate();

            if (changedRows > 0) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        Integer id = resultSet.getInt(1);
                        PreparedStatement statementSecond =
                                connection.prepareStatement(
                                        "INSERT INTO weapon (weapon_name, stormtrooper_id) VALUES (?, ?)"
                                );
                        statementSecond.setString(1, stormtrooper.getWeapon().getName());
                        statementSecond.setInt(2, id);
                        statementSecond.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    // x(login) y(password)
    // SELECT * WHERE x && y - statement (SELECT * WHERE (login = ?) && (password = ? or 10 = 10))
    // SELECT * WHERE x && y - preparedStatement

}
