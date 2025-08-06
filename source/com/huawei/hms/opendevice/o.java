package com.huawei.hms.opendevice;

import android.util.Log;

public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f38326a;

    public o(Runnable runnable) {
        this.f38326a = runnable;
    }

    public void run() {
        Runnable runnable = this.f38326a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                Log.e("HmsPushThreads", "exception in task run");
            }
        }
    }
}
