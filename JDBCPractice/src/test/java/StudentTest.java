import getSqlSessionFactory.GetSqlSessionFactory;
import mybatis.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class StudentTest {
    @Test
    public void selectById() {//通过id查询
        try {
//            testStudent s=new testStudent();创建testStudent对象调用getSession方法，可不写
            //调用上面抽出来的getSession方法，获取sqlSession
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //通过SqlSession操作数据库
            //第一个参数：映射文件中statement的id，= namespace + statement的id
            //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
            //selectOne表示查询出一条记录进行映射
            Student stu = sqlSession.selectOne("test.findStudentById", 1);
            //输出获取的学生的信息
            System.out.println(stu);
            //释放资源
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectStudentByName() {//查询所有学生
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
//          用selectList表示查询出一条记录进行映射，映射存储在List集合中
            List<Student> students = sqlSession.selectList("test.findByName", "武");
//          创建迭代器好输出遍历结果
            Iterator<Student> stu = students.iterator();
            while (stu.hasNext()) {
                System.out.println(stu.next());
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectStudentByNumber() {//查询所有学生
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
//          用selectList表示查询出一条记录进行映射，映射存储在List集合中
            List<Student> students = sqlSession.selectList("test.findByNumber", "2345");
//          创建迭代器好输出遍历结果
            Iterator<Student> stu = students.iterator();
            while (stu.hasNext()) {
                System.out.println(stu.next());
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll() {//查询所有学生
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
//          用selectList表示查询出一条记录进行映射，映射存储在List集合中
            List<Student> students = sqlSession.selectList("test.findAllStudent");
//          创建迭代器好输出遍历结果
            Iterator<Student> stu = students.iterator();
            while (stu.hasNext()) {
                System.out.println(stu.next());
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {//新增学生
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //创建学生对象，包含id，name，number，create_at和update_at准备插入表格
            Student stu = new Student();
//            stu.setId(5);
            stu.setName("三元");
            sqlSession.insert("test.insertStudent", stu);
            sqlSession.commit();//提交事务
            sqlSession.close();//释放资源
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void delete() {//删除学生
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("test.deleteStudent", 5);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {//更新学生信息
        try {
            SqlSessionFactory sqlSessionFactory = GetSqlSessionFactory.getSqlSessionFactory();
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Long time = System.currentTimeMillis();
            Student stu = new Student();
            stu.setId(2);
            stu.setNumber("33435");
            stu.setName("一角钱");
            stu.setUpdate_at(time);
            sqlSession.update("test.updateStudent", stu);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
