package com.mvc.test.dao;

import com.mvc.test.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    @Transactional
    public List<UserEntity> getUsersList() {
        return entityManager.createQuery("from UserEntity").getResultList();
    }
}
