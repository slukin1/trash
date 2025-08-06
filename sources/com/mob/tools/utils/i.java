package com.mob.tools.utils;

import com.mob.tools.MobLog;

public abstract class i implements Runnable {
    public abstract void a() throws Throwable;

    public final void run() {
        try {
            a();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }
}
