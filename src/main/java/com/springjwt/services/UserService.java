package com.springjwt.services;

import com.springjwt.daoimp.UserDaoImp;
import com.springjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User>{

    UserDaoImp userDaoImp;

    @Autowired
    public void setUserDaoImp(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    @Override
    public List<User> getAll() {
        return userDaoImp.getAll();
    }

    @Override
    public User findById(long id) {
        return userDaoImp.findById(id);
    }

    @Override
    public User save(User item) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        item.setPassword(bCryptPasswordEncoder.encode(item.getPassword()));
        return userDaoImp.save(item);
    }

    @Override
    public void update(User item) {
        userDaoImp.update(item);
    }

    @Override
    public void delete(long id) {
        userDaoImp.delete(id);
    }

    public User findByUsername(String username){
        return userDaoImp.findByUsername(username);
    }
}
