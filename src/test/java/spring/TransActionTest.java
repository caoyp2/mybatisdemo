package spring;

import com.spring.transaction.dao.UserCardDao;
import com.spring.transaction.dao.impl.UserCardDaoImpl;
import com.spring.transaction.domain.UserCard;
import com.spring.transaction.service.UserCardService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransActionTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("SpringJdbcTemplate.xml");

        UserCardDao usercardDao = context.getBean("usercardDao", UserCardDaoImpl.class);
        UserCard userCard = new UserCard();
        userCard.setUsername("zs");
        userCard.setMoney(800f);
        usercardDao.updateCard(userCard);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("transaction.xml");

        UserCardService userCardService = context.getBean("userCardService", UserCardService.class);
        userCardService.transfer("zs","ls",200f);
    }
}
