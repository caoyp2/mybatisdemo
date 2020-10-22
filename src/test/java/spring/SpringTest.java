package spring;

import com.spring.People;
import com.spring.PeopleService;
import com.spring.Student;
import com.spring.annotation.AnnotationConfigure;
import com.spring.annotation.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void getBean1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        //获取方式二
        Student student1 = context.getBean("student", Student.class);
        System.out.println(student1);
    }

    @Test
    public void getBean2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //获取方式二
        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
    }

    @Test
    public void getBean3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //获取方式二
        Student student1 = context.getBean("student2", Student.class);
        System.out.println(student1);
    }

    @Test
    public void getBean4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //获取方式二
        Student student1 = context.getBean("student3", Student.class);
        System.out.println(student1);
    }

    @Test
    public void getBeanbyAnnotation(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //获取方式二
        People people = context.getBean("people", People.class);
        System.out.println(people);
    }

    @Test
    public void getBeanbyAnnotation1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //获取方式二
        PeopleService peopleService = context.getBean("peopleService",PeopleService.class);
        peopleService.savePeople();
        context.close();
    }

    @Test
    public void getBeanbyAnnotation2(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationConfigure.class);
        //获取方式二
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}
