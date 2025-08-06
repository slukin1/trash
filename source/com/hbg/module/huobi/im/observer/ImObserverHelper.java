package com.hbg.module.huobi.im.observer;

public class ImObserverHelper extends BaseObserverHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile ImObserverHelper f20531b;

    public static ImObserverHelper b() {
        if (f20531b == null) {
            synchronized (ImObserverHelper.class) {
                if (f20531b == null) {
                    f20531b = new ImObserverHelper();
                }
            }
        }
        return f20531b;
    }
}
