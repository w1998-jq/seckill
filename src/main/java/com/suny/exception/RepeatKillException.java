package com.suny.exception;

/**
 * @ClassName RepeatKillException
 * Description
 * @Author jqWang
 * Date 2021/11/25 20:11
 **/
public class RepeatKillException extends SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }

}
