import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserMapperService;

import java.util.List;

public class TestUserMapperService {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        User user = userMapperService.findUserById(3);
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        List<User> list = userMapperService.findUserByName("万");
        System.out.println(list);
    }

    @Test
    public void testFindUserByNumber() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        List<User> list = userMapperService.findUserByNumber("334");
        System.out.println(list);
    }

    @Test
    public void testFindUsers() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        List<User> list = userMapperService.findUsers();
        System.out.println(list);
    }
/*
    @Test
    public void testInsertUser() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        User user = new User();
        Long time = System.currentTimeMillis();
//        user.setId(2);
        user.setUsername("曹老师");
        user.setNumber("343455");
        user.setCreate_at(time);
        user.setUpdate_at(time);
        userMapperService.insertUser(user);
    }

    @Test
    public void testDeleteUser() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        userMapperService.deleteUser(2);
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        User user = new User();
        Long time = System.currentTimeMillis();
        user.setId(2);
        user.setUsername("补俊");
        user.setNumber("246456");
        user.setUpdate_at(time);
        userMapperService.updateUser(user);
    }
    @Test
    public void testUpdateAndFindById() throws Exception {
        UserMapperService userMapperService = applicationContext.getBean(UserMapperService.class);
        User user = new User();
        Long time = System.currentTimeMillis();
        user.setId(3);
        user.setUsername("晋金");
        user.setNumber("246456");
        user.setUpdate_at(time);
        userMapperService.updateAndFindById(user);
//        userMapperService.updateUser(user);
//        System.out.println(userMapperService.findUserById(user.getId()));
    }
*/
}
