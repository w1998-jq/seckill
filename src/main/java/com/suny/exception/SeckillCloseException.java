package com.suny.exception;

/**
 * @ClassName SeckillCloseException
 * Description
 * @Author jqWang
 * Date 2021/11/25 20:10
 **/
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
