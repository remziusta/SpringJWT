package com.springjwt.daoimp;

import com.springjwt.dao.RoleDao;
import com.springjwt.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        return entityManager.createQuery("from Role",Role.class).getResultList();
    }

    @Override
    public Role findById(long id) {
        return entityManager.find(Role.class,id);
    }

    @Transactional
    @Override
    public Role save(Role item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public Role update(Role item) {
        return entityManager.merge(item);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.getReference(Role.class,id));
    }
}
