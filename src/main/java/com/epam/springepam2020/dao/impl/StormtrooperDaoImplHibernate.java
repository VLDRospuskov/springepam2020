package com.epam.springepam2020.dao.impl;

import com.epam.springepam2020.dao.StormtrooperDao;
import com.epam.springepam2020.model.Stormtrooper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StormtrooperDaoImplHibernate implements StormtrooperDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Stormtrooper> getAll() {
        Session session = sessionFactory.openSession();
        List<Stormtrooper> stormtroopers =
                session.createQuery("from Stormtrooper", Stormtrooper.class).list();
        return stormtroopers;
    }

    public void save(Stormtrooper stormtrooper) {
        Session session = sessionFactory.openSession();
        /*
        * if (dgsdfg) stormtrooper.set(dffg)
        * ...
        * stormtrooper.setStatus(ACTIVE)
        * .....
        * Transcational(propogation = REQUIRES_NEW)
        * setStatus(Status))
        *
        * .if (fgdhfghfg)
        * . stormtrooper.setStatus(INACTIVE)
        * */
        session.save(stormtrooper);
    }

//    @Override
//    public void save(Stormtrooper stormtrooper) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(stormtrooper);
//            transaction.commit();
//        } catch (Exception ex) {
//            transaction.rollback();
//        } finally {
//            session.close();
//        }
//    }

    @Override
    public void deleteById(Integer id) {

    }
}
