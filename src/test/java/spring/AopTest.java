package spring;

import com.spring.aop.IProducer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void aopTest01(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("aop.xml");
        IProducer iProducer = (IProducer) context.getBean("aopProducer");
        iProducer.saveAccount();
    }
}
