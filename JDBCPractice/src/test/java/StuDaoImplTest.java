import dao.StuDao;
import mybatis.StuDaoImpl;
import mybatis.Student;
import org.junit.Test;

public class StuDaoImplTest {

    @Test
    public void testFindStudentById() throws Exception {
        //创建StuDao的对象
        StuDao stuDao = new StuDaoImpl();
        System.out.println(stuDao.selectById(2));
    }

    @Test
    public void testFindStudentByName() throws Exception {
        StuDao stuDao = new StuDaoImpl();
        System.out.println(stuDao.selectByName("万全林"));
    }

    @Test
    public void testFindStudentByNumber() throws Exception {
        StuDao stuDao = new StuDaoImpl();
        System.out.println(stuDao.selectByNumber("2345"));
    }

    @Test
    public void testFindStudents() throws Exception {
        StuDao stuDao = new StuDaoImpl();
        System.out.println(stuDao.selectAll());
    }

    @Test
    public void testInsertStudent() throws Exception {

        StuDao stuDao = new StuDaoImpl();
        Long time = System.currentTimeMillis();
        Student stu = new Student();
        stu.setId(5);
        stu.setName("五五开");
        stu.setNumber("42475");
        stu.setCreate_at(time);
        stu.setUpdate_at(time);
        stuDao.insert(stu);
    }

    @Test
    public void testDeleteStudent() throws Exception {
        StuDao stuDao = new StuDaoImpl();
        stuDao.delete(5);
    }

    @Test
    public void testUpdateStudent() throws Exception {
        StuDao stuDao = new StuDaoImpl();
        Long time = System.currentTimeMillis();
        Student stu = new Student();
        stu.setId(3);
        stu.setName("宋晓胜");
        stu.setNumber("4234");
        stu.setUpdate_at(time);
        stuDao.update(stu);
    }
}
