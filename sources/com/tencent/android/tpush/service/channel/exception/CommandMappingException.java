package com.tencent.android.tpush.service.channel.exception;

public class CommandMappingException extends Exception {
    public CommandMappingException(String str) {
        super(str);
    }

    public CommandMappingException(String str, Throwable th2) {
        super(str, th2);
    }
}
