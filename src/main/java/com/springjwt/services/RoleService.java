package com.springjwt.services;

import com.springjwt.dao.RoleDao;
import com.springjwt.daoimp.RoleDaoImp;
import com.springjwt.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IService<Role> {

    RoleDaoImp roleDaoImp;

    @Autowired
    public void setRoleDaoImp(RoleDaoImp roleDaoImp) {
        this.roleDaoImp = roleDaoImp;
    }

    @Override
    public List<Role> getAll() {
        return roleDaoImp.getAll();
    }

    @Override
    public Role findById(long id) {
        return roleDaoImp.findById(id);
    }

    @Override
    public Role save(Role item) {
        return roleDaoImp.save(item);
    }

    @Override
    public void update(Role item) {
        roleDaoImp.update(item);
    }

    @Override
    public void delete(long id) {
        roleDaoImp.delete(id);
    }
}
