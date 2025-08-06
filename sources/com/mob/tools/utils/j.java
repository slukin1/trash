package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.tools.MobLog;

public abstract class j extends Thread {
    public j() {
    }

    public abstract void a() throws Throwable;

    public void a(Throwable th2) {
        MobLog.getInstance().d(th2);
    }

    public final void run() {
        try {
            a();
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public j(String str) {
        if (!TextUtils.isEmpty("M-")) {
            setName("M-" + str);
        }
    }
}
