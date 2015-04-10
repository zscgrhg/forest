package com.frost.forest.gen.bean.service;


import com.frost.forest.pen.model.Users;
import com.frost.forest.pen.bean.service.AbstractFacade;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class UsersFacade extends AbstractFacade<Users> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public UsersFacade() {
        super(Users.class);
    }
}
