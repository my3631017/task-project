import com.pojo.User;
import com.service.UserDaoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestUserDaoService {
    private ApplicationContext applicationContext;

    @Before
    public void setApplicationContext() {
        applicationContext =
                new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void findUsers() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        List<User> list = userDaoService.findUsers();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void findUsersByPage() throws Exception {
        UserDaoService userDaoService = applicationContext.getBean(UserDaoService.class);
        List<User> list = userDaoService.findUsersByPage(0, 5);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
