package com.wang.exception;

/**
 * @ClassName SeckillException
 * Description 秒杀基础异常
 * @Author jqWang
 * Date 2021/11/24 13:37
 **/
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
