package com.huobi.network.listener;

import com.huobi.network.listener.HttpLoggingInterceptor;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;

public class HbInterceptorLogger implements HttpLoggingInterceptor.a {

    /* renamed from: b  reason: collision with root package name */
    public static String f78050b = "REST";

    /* renamed from: a  reason: collision with root package name */
    public String f78051a;

    public HbInterceptorLogger() {
    }

    public void log(String str) {
        k.p(f78050b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.f78051a, str, false);
    }

    public HbInterceptorLogger(String str) {
        this.f78051a = str;
    }
}
