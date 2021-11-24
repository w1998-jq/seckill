package com.wang.exception;

/**
 * @ClassName RepeatKillException
 * Description 秒杀重复异常
 * @Author jqWang
 * Date 2021/11/24 13:38
 **/
public class RepeatKillException extends RuntimeException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
