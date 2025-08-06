package com.huobi.jpush.listener;

import gm.a;

public class StatusObserver {

    /* renamed from: b  reason: collision with root package name */
    public static volatile StatusObserver f74653b;

    /* renamed from: a  reason: collision with root package name */
    public a f74654a;

    public static StatusObserver a() {
        if (f74653b == null) {
            synchronized (StatusObserver.class) {
                f74653b = new StatusObserver();
            }
        }
        return f74653b;
    }

    public a b() {
        return this.f74654a;
    }
}
