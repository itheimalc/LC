package com.itheima.web;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.Impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext:记载类路径下的配置文件，要求配置文件必须在类路径下，不在则无法加载
     *      FileSystemXmlApplicationContext:记载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext:读取注解创建容器
     *
     * 核心容器两个接口的问题：
     *      ApplicationContext(单例对象使用)：在构建核心容器时，创建对象采取的策略是才用立即加载的方式，只要一读取完配置文件马上就创建配置文件中配置对象
     *      BeanFactory(多例对象使用)：在构建核心容器时，创建对象采取的策略是采用延迟加载的方式，什么时候根据id获取对象了，什么时候真正创建对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\bean.xml");
        //根据id获取Bean对象
        AccountService accountService1 = (AccountService) ac.getBean("accountService");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        System.out.println(accountService1);
        System.out.println(accountDao);

        //---------BeanFactory-----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        AccountService accountService2 = (AccountService)beanFactory.getBean("accountService");
        System.out.println(accountService2);
    }
}
