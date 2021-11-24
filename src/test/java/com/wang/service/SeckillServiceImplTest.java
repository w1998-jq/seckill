package com.wang.service;

import com.wang.pojo.Seckill;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml",
        "classpath:applicationContext-service.xml"})
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