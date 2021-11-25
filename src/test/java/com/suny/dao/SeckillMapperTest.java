package com.suny.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class SeckillMapperTest {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void reduceNumber() {
        System.out.println(seckillMapper);
        /*long seckillId=1000;
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(seckillMapper + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        int i = seckillMapper.reduceNumber(seckillId, localDateTime);
        System.out.println(i);*/
    }
}