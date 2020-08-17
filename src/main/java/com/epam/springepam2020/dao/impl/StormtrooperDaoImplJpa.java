package com.epam.springepam2020.dao.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.model.Stormtrooper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StormtrooperDaoImplJpa implements StormtrooperDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Stormtrooper> getAll() {
        return entityManager.createQuery("select s from Stormtrooper s", Stormtrooper.class).getResultList();
    }

    @Override
    public void save(Stormtrooper stormtrooper) {
        entityManager.persist(stormtrooper);
    }

    @Override
    public void deleteById(Integer id) {

    }

}
