package com.springjwt.dao;

import com.springjwt.model.User;

public interface UserDao extends ICrud<User>{
    User findByUsername(String username);
}
