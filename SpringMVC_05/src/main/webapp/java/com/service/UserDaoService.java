package com.service;

import com.dao.UserDao;
import com.pojo.User;

import java.util.Iterator;
import java.util.List;

public class UserDaoService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findUsers() throws Exception {
        List<User> list = userDao.findUsers();
        return list;
    }

    public List<User> findUsersByPage(int start, int perPageUsers) throws Exception {
        List<User> list = userDao.findUsersByPage(start, perPageUsers);
        return list;
    }
}
