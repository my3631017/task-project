package dao;

import entity.User;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

//@Repository(value = "userMapper")
public interface UserMapper {
    User findUserById(int id) throws IOException;

    List<User> findUserByName(String name) throws IOException;

    List<User> findUserByNumber(String number) throws IOException;

    List<User> findUsers() throws IOException;

    void insertUser(User user) throws IOException;

    void deleteUser(int id) throws IOException;

    void updateUser(User user) throws IOException;
}
