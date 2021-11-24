package com.wang.exception;

/**
 * @ClassName SeckillCloseException
 * Description 秒杀已经关闭异常
 * @Author jqWang
 * Date 2021/11/24 13:38
 **/
public class SeckillCloseException extends RuntimeException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
