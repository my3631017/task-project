package mybatis;

import getSqlSessionFactory.GetSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StuDaoImpl implements dao.StuDao {
    private SqlSessionFactory sqlSessionFactory;

    public Student selectById(int id) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("test.findStudentById", id);
        sqlSession.close();
        return student;
    }

    public Student selectByName(String name) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("test.findByName", name);
        sqlSession.close();
        return student;
    }
    public Student selectByNumber(String number) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("test.findByNumber",number);
        sqlSession.close();
        return student;
    }

    public List<Student> selectAll() throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> list = sqlSession.selectList("test.findAllStudent");
        sqlSession.close();
        return list;
    }

    public void insert(Student student) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertStudent", student);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteStudent", id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Student student) throws Exception {
        sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateStudent", student);
        sqlSession.commit();
        sqlSession.close();
    }
}