package service;

import dao.UserMapper;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

//@Service
public class UserMapperService {
//    @Resource(name = "userMapper")
    private UserMapper userMapper;//使用注解的方式注入属性，就不需要手动生成set方法。

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUserById(int id) throws Exception {
        return userMapper.findUserById(id);
    }

    public List<User> findUserByName(String username) throws IOException {
        List<User> list = userMapper.findUserByName(username);
        return list;
    }

    public List<User> findUserByNumber(String number) throws IOException {
        List<User> list = userMapper.findUserByNumber(number);
        return list;
    }

    public List<User> findUsers() throws IOException {
        List<User> list = userMapper.findUsers();
        return list;
    }

    public void insertUser(User user) throws IOException {
        userMapper.insertUser(user);
    }

    public void deleteUser(int id) throws IOException {
        userMapper.deleteUser(id);
    }

    public void updateUser(User user) throws IOException {
        userMapper.updateUser(user);
    }
    @Transactional
    public void updateAndFindById(User user) throws Exception {
        userMapper.updateUser(user);
//        int i=10/0;
        System.out.println(userMapper.findUserById(user.getId()));
    }
}
