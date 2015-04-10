package com.frost.forest.gen.bean.service;


import com.frost.forest.pen.model.Resources;
import com.frost.forest.pen.bean.service.AbstractFacade;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ResourcesFacade extends AbstractFacade<Resources> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ResourcesFacade() {
        super(Resources.class);
    }
}
