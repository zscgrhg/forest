package com.frost.forest.gen.bean.service;


import com.frost.forest.pen.model.Authorities;
import com.frost.forest.pen.bean.service.AbstractFacade;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class AuthoritiesFacade extends AbstractFacade<Authorities> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public AuthoritiesFacade() {
        super(Authorities.class);
    }
}
