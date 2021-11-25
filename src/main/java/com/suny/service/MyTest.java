package com.suny.service;

import com.suny.dao.SeckillMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * @ClassName MyTest
 * Description
 * @Author jqWang
 * Date 2021/11/25 20:43
 **/
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class MyTest {
    @Autowired
    private SeckillService seckillService;

    @Test
    public void test(){
        System.out.println(seckillService);
    }
    public static void main(String[] args) {

        ClassPathXmlApplicationContext cls = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-service.xml");
        System.out.println(cls.getBean("seckillService"));
    }
}
