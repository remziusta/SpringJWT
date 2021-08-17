package com.springjwt.daoimp;

import com.springjwt.dao.UserDao;
import com.springjwt.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class,id);
    }

    @Transactional
    @Override
    public User save(User item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public User update(User item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.getReference(User.class,id));
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("from User where username = :username", User.class).setParameter("username", username).getSingleResult();
    }
}
