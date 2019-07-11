package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select name from tb_test")
    List<User> findUsers() throws Exception;

    @Select("select * from tb_test limit #{start},#{perPageUsers}")
    List<User> findUsersByPage(@Param("start") int start, @Param("perPageUsers") int perPageUsers) throws Exception;
}