package com.hbg.module.huobi.im.observer;

public class ActiveObserverHelper extends BaseObserverHelper {

    /* renamed from: b  reason: collision with root package name */
    public static volatile ActiveObserverHelper f20529b;

    public static ActiveObserverHelper b() {
        if (f20529b == null) {
            synchronized (ActiveObserverHelper.class) {
                if (f20529b == null) {
                    f20529b = new ActiveObserverHelper();
                }
            }
        }
        return f20529b;
    }
}
