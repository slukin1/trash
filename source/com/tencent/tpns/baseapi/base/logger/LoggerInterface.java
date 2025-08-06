package com.tencent.tpns.baseapi.base.logger;

public interface LoggerInterface {
    void d(String str, String str2);

    void d(String str, String str2, Throwable th2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th2);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th2);

    void v(String str, String str2);

    void v(String str, String str2, Throwable th2);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th2);
}
