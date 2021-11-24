package com.wang.dao;

import com.wang.pojo.Seckill;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName SeckillMapperTest
 * Description
 * @Author jqWang
 * Date 2021/11/24 10:24
 **/

public class SeckillMapperTest {
    private SeckillMapper seckillMapper;

    @Test
    public void reduceNumber() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        SeckillMapper mapper = (SeckillMapper)context.getBean("seckillMapper");
        long seckillId=1000;
        LocalDateTime localDateTime=LocalDateTime.now();
        int i = mapper.reduceNumber(seckillId, localDateTime);
        System.out.println(i);
    }

    @Test
    public void queryById() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        SeckillMapper mapper = (SeckillMapper)context.getBean("seckillMapper");
        long seckillId = 1000;
        Seckill seckill = mapper.queryById(seckillId);
        System.out.println(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillMapper.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill.toString());
        }
    }
}
