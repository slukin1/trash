package com.huawei.secure.android.common.util;

public class SecurityCommonException extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private static final long f38669c = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f38670a;

    /* renamed from: b  reason: collision with root package name */
    private String f38671b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f38671b;
    }

    public String getRetCd() {
        return this.f38670a;
    }

    public SecurityCommonException(Throwable th2) {
        super(th2);
    }

    public SecurityCommonException(String str, Throwable th2) {
        super(str, th2);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f38671b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f38670a = str;
        this.f38671b = str2;
    }
}
