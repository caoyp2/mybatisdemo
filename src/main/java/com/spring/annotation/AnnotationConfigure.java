package com.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @Configuration 标识这个类是一个配置类
 *      当使用AnnotationConfigApplicationContext读取配置时，@Configuration可省略
 *@ComponentScan配置扫描的包
 *
 *@Bean 和xml中bean标签一致
 *    属性：name 用于指定容器的key,相当于xml bean标签的id属性
 *
 * @Import(xxx.class) 作用：导入其他的配置类
 *      属性: value 用于指定其配置类的字节码。
 *            当我们使用Import的注解之后，有Import注解的类就是主配置类，导入的配置类就是子配置类
 *
 * @PropertySource 作用：配置文件
 *      属性：value 用于指定配置文件的路径
 */
@Configuration
@ComponentScan(basePackages = "com.spring.annotation")
@PropertySource(value = "jdbcConfig.properties")
public class AnnotationConfigure {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String jdbcurl;

    @Bean(name="car")
    public Car car(){
        System.out.println(driver);
        System.out.println(jdbcurl);
        return new Car();
    }
}
