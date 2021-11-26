package com.suny.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
public class SuccessKilledMapperTest {

    @Autowired
    private SuccessKilledMapper successKilledMapper;
    @Test
    public void insertSuccessKilled() {
        System.out.println(successKilledMapper);
    }

    @Test
    public void queryByIdWithSeckill() {
    }
}