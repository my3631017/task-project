import com.tools.MD5;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMd5 {
    @Test
    public void testDes() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        MD5 md5 = context.getBean(MD5.class);
        System.out.println(md5.encryption("23764")[0]);
        System.out.println(md5.md5encryption("234235"));
    }
}
