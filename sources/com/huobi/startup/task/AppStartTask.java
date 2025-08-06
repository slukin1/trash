package com.huobi.startup.task;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public abstract class AppStartTask {

    /* renamed from: a  reason: collision with root package name */
    public CountDownLatch f81289a;

    public AppStartTask() {
        this.f81289a = new CountDownLatch(a() == null ? 0 : a().size());
    }

    public List<Class<? extends AppStartTask>> a() {
        return null;
    }
}
