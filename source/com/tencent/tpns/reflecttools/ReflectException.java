package com.tencent.tpns.reflecttools;

public class ReflectException extends RuntimeException {
    private static final long serialVersionUID = -6213149635297151442L;

    public ReflectException() {
    }

    public ReflectException(String str) {
        super(str);
    }

    public ReflectException(String str, Throwable th2) {
        super(str, th2);
    }

    public ReflectException(Throwable th2) {
        super(th2);
    }
}
