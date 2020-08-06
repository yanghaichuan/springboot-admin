package com.yhc.example.web.exception;

/**
 * @author ：yanghc
 * @date ：2019/7/1 09:26
 * @description：登录异常
 */
public class LoginException extends RuntimeException {
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
