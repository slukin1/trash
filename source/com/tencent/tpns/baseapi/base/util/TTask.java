package com.tencent.tpns.baseapi.base.util;

public abstract class TTask implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public String f49826f;

    public TTask() {
        this("undefined");
    }

    public abstract void TRun();

    public void run() {
        try {
            TRun();
        } catch (Throwable unused) {
        }
    }

    public TTask(String str) {
        this.f49826f = str;
    }
}
