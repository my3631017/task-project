import com.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestCustomerDao {
    @Autowired
    CustomerDao customerDao;

    @Test
    public void testFind() throws Exception {
        System.out.println(customerDao.findCustomer("万全林"));
    }

}
