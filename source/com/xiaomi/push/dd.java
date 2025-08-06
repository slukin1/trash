package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class dd implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private LoggerInterface f51580a = null;

    /* renamed from: b  reason: collision with root package name */
    private LoggerInterface f51581b = null;

    public dd(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f51580a = loggerInterface;
        this.f51581b = loggerInterface2;
    }

    public void log(String str) {
        LoggerInterface loggerInterface = this.f51580a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f51581b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    public void setTag(String str) {
    }

    public void log(String str, Throwable th2) {
        LoggerInterface loggerInterface = this.f51580a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th2);
        }
        LoggerInterface loggerInterface2 = this.f51581b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th2);
        }
    }
}
