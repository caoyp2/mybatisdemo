package spring;

import com.spring.springtransaction.service.UserCardService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("springtransaction.xml");
        UserCardService userCardService = context.getBean("userCardService", UserCardService.class);
        userCardService.transfer("zs","ls",200f);
    }
}
