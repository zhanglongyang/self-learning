package com.zhanglongyang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        Person person = (Person) context.getBean("person");
        System.out.println(person.getAge());
        System.out.println(person.getAddress());
        System.out.println(person.getBasket());

        ((ClassPathXmlApplicationContext) context).close();
    }
}
