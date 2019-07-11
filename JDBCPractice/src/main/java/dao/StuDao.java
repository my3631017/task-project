package dao;

import mybatis.Student;

import java.util.List;

public interface StuDao {
    Student selectById(int id)throws Exception;
    Student selectByName(String name)throws Exception;
    Student selectByNumber(String number)throws Exception;
    List<Student> selectAll()throws Exception;
    void insert(Student student)throws Exception;
    void delete(int id)throws Exception;
    void update(Student student)throws Exception;
}
