package com.huobi.login.usercenter.utils;

public class TokenErrorException extends RuntimeException {
    public TokenErrorException(String str) {
        super(str);
    }
}
