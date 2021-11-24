package com.wang.service;

import com.wang.pojo.Seckill;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-service.xml"})
class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillService;

    @Test
    void getSeckillList() {
        System.out.println(seckillService);
        List<Seckill> seckillList = seckillService.getSeckillList();
        System.out.println(seckillList.toString());
    }

    @Test
    void getById() {
    }

    @Test
    void exportSeckillUrl() {
    }

    @Test
    void executeSeckill() {
    }
}