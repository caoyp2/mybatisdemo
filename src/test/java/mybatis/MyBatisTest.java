package mybatis;

import com.domain.Account;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    @Test
    public void  findUserAllTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句
        List<User> listUser = session.selectList("com.domain.User.findUserAll");
        for (User user : listUser) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void  saveUserTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句
        User user = new User();
        user.setUsername("张天天");
        user.setSex("M");
        user.setAddress("深圳市");
        user.setBirthday(new Date());
        System.out.println("保存前：" + user);
        session.insert("com.domain.User.saveUser",user);
        System.out.println("保存后：" + user);
        session.commit();
        session.close();
    }

    @Test
    public void  updateUserTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(8);
        user.setUsername("update user");
        user.setSex("F");
        user.setAddress("光明顶");
        session.update("com.domain.User.updateUser",user);
        session.commit();
        session.close();
    }

    @Test
    public void  deleteUserTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        session.delete("com.domain.User.deleteUserById",8);
        session.commit();
        session.close();
    }

    @Test
    public void  findUserByUsernameTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        List<User> users = session.selectList("com.domain.User.findUserByUsername", "%张%");
        for (User user : users) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }

    /**
     * 查询用户及用户下的账户
     * @throws IOException
     */
    @Test
    public void  findUserAndAccountTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        List<User> users = session.selectList("com.domain.User.findUserAndAccount");
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    /**
     * 查询用户及用户下的账户
     * @throws IOException
     */
    @Test
    public void  findAccountAndUserTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        List<Account> accounts = session.selectList("com.domain.Account.findAccountAndUser");
        for (Account account : accounts) {
            System.out.println(account);
        }
        session.close();
    }

    /**
     * 根据条件查询用户
     * @throws IOException
     */
    @Test
    public void  findUserByConditionTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("%张%");
        List<User> users = session.selectList("com.domain.User.findUserByCondition",user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        session.close();
    }

    /**
     * 默认会开启一级缓存，一级缓存作用在同一个opensession,
     * 查询相同的数据时，第二次会使用缓存数据，若执行update,delete等操作后一级缓存会失效
     * @throws IOException
     */
    @Test
    public void oneLevalCacheTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句
        List<User> listUser = session.selectList("com.domain.User.findUserAll");

        List<User> listUser1 = session.selectList("com.domain.User.findUserAll");
        System.out.println(listUser == listUser1);
    }

    /**
     * 二级缓存
     *同一个sqlSessionFactory获取的openSession查询相同的数据时，第二次会使用缓存，
     * 执行update,delete等操作后二级缓存会失效
     */
    @Test
    public void twoLevalCacheTest() throws IOException {
        String resource = "sqlMapperConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();

        // 最后通过 session 的 selectList() 方法调用 sql 语句
        List<User> listUser = session.selectList("com.domain.User.findUserAll");
        session.close();

        SqlSession session1 = sqlSessionFactory.openSession();
        List<User> listUser1 = session1.selectList("com.domain.User.findUserAll");
        session1.close();
        System.out.println(listUser == listUser1);
    }
}
