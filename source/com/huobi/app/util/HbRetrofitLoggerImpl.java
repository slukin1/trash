package com.huobi.app.util;

import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean;
import i6.d;
import i6.k;

public class HbRetrofitLoggerImpl implements RetrofitLogger.b {
    public void a(String str, String str2) {
        k.d(str, str2);
    }

    public void b(String str, Throwable th2) {
        d.f(str, th2);
    }

    public void c(SocketReportBean socketReportBean) {
    }

    public void d(String str) {
        d.b(str);
    }

    public void e(String str) {
        d.d(str);
    }

    public void f(String str) {
        k.c(str);
    }
}
