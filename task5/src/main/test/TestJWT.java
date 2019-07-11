import com.tools.JwtUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestJWT {
    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void testGenerateToken() {
        String token = jwtUtil.generateToken("晋良金", 60000);
        System.out.println(token);
    }

    @Test
    public void testParseToken() {
        Map<String, Object> result = jwtUtil.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJnZW5lcmF0ZVRpbWUiOiJwaHZubzBtMjN2OUtsdVc5ZmU2V1lPMklGUFFCdTc4cDVJMEFkK3kycG1JPSIsImV4cCI6MTUyOTQyMjkyMiwiaWF0IjoxNTI5NDIyODYyLCJ1c2VybmFtZSI6InZhS0NRNml2NVcwYU40TnUwaVVJNnc9PSJ9.wFdVf4r4b0S4yQxU1roWHLJjlfXlmTkOOuuikslOACw");
        Collection<Object> collection = result.values();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
