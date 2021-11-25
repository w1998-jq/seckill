package com.suny.exception;

/**
 * @ClassName SeckillException
 * Description
 * @Author jqWang
 * Date 2021/11/25 20:09
 **/
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
