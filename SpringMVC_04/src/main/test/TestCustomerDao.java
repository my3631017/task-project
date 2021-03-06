import com.impl.CustomerServiceImpl;
import com.pojo.Customer;
import com.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestCustomerDao {
    @Autowired
    CustomerService customerService;

//    @Before
//    public void setContext() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/*.xml");
//        customerService = context.getBean(CustomerServiceImpl.class);
//    }

    @Test
    public void testFindCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setUsername("刘君健");
        customer.setPassword("123456");
        System.out.println(customerService.login(customer));
    }

    @Test
    public void testInsertCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setUsername("陈丹婷");
        customer.setPassword("123456");
        System.out.println(customerService.register(customer));
    }
}
