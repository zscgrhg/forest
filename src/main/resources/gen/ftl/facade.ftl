package com.frost.forest.gen.bean.service;


import ${fullName};
import com.frost.forest.pen.bean.service.AbstractFacade;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class ${name}Facade extends AbstractFacade<${name}> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ${name}Facade() {
        super(${name}.class);
    }
}
