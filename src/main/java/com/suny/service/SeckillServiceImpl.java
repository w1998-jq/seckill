package com.suny.service;

import com.suny.dao.SeckillMapper;
import com.suny.dao.SuccessKilledMapper;
import com.suny.dto.Exposer;
import com.suny.dto.SeckillExecution;
import com.suny.exception.RepeatKillException;
import com.suny.exception.SeckillCloseException;
import com.suny.exception.SeckillException;
import com.suny.pojo.Seckill;

import com.suny.pojo.SuccessKilled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName SeckillServiceImpl
 * Description
 * @Author jqWang
 * Date 2021/11/25 20:13
 **/
@Service("seckillService")
public class SeckillServiceImpl implements SeckillService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /* 加入一个盐值,用于混淆*/
    private final String salt = "thisIsASaltValue";

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public List<Seckill> getSeckillList() {
        return seckillMapper.queryAll(0,4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillMapper.queryById(seckillId);
        if(seckill == null){
            logger.warn("查询不到秒杀产品得记录");
            return new Exposer(false,seckillId);
        }
        LocalDateTime startTime = seckill.getStartTime();
        LocalDateTime endTime = seckill.getEndTime();
        LocalDateTime nowTime = LocalDateTime.now();
        //   开始时间大于现在的时候说明没有开始秒杀活动    秒杀活动结束时间小于现在的时间说明秒杀已经结束了
       if (!nowTime.isAfter(startTime)) {
            logger.info("现在的时间不在开始时间后面,未开启秒杀");
            return new Exposer(false, seckillId, nowTime, startTime, endTime);
        }
        if (!nowTime.isBefore(endTime)) {
            logger.info("现在的时间不在结束的时间之前,可以进行秒杀");
            return new Exposer(false, seckillId, nowTime, startTime, endTime);
        }
        return new Exposer(false, seckillId, nowTime, startTime, endTime);
    }


    private String getMd5(long seckillId){
        String base = seckillId + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException, SeckillCloseException {
        if(md5 == null || md5.equals(getMd5(seckillId))){
            logger.error("秒杀数据被篡改");
            throw new SeckillException("seckill data rewrite");
        }
        LocalDateTime nowTime = LocalDateTime.now();

        try {
            int reduceNum = seckillMapper.reduceNumber(seckillId,nowTime);
            if(reduceNum <= 0){
                logger.warn("没有更新数据库记录，说明秒杀结束");
                throw new SeckillCloseException("secKill is closed");
            }else{
                int insertCount = successKilledMapper.insertSuccessKilled(seckillId,userPhone);
                if(insertCount <= 0){
                    throw new RepeatKillException("secKill repeated");
                }else{
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId,1,"秒杀成功");

                }
            }
        }catch (SeckillCloseException | RepeatKillException e){
            throw  e;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("secKill inner :" + e.getMessage());
        }
    }
}
