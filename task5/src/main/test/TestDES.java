import com.tools.DES;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDES {
    @Test
    public void testDes() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        DES des = context.getBean(DES.class);
        System.out.println(des.encrypt("23424"));
        System.out.println(des.decrypt(des.encrypt("23424")));
    }
}
