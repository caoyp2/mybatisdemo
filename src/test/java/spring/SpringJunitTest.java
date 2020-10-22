package spring;

import com.spring.annotation.AnnotationConfigure;
import com.spring.annotation.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) 标识运行的是spring容器的形式运行junit
 *@ContextConfiguration(classes = AnnotationConfigure.class) 指定加载到容器的资源
 *      属性： classes 指定配置类的class
 *               locations 指定配置得xml文件路径
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AnnotationConfigure.class)
public class SpringJunitTest {
    @Autowired
    private Car car;

    @Test
    public void testCar(){
        System.out.println(car);
    }
}
