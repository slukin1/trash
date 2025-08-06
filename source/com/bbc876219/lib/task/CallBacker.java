package com.bbc876219.lib.task;

import android.os.Process;
import com.bbc876219.lib.zlog.Log;
import java.util.concurrent.Callable;

public abstract class CallBacker<T> implements Callable<T> {

    /* renamed from: b  reason: collision with root package name */
    public int f63234b = 10;

    public abstract T a();

    public T call() {
        long currentTimeMillis = System.currentTimeMillis();
        Process.setThreadPriority(this.f63234b);
        Log.b("CallBacker", "call() start  " + getClass().getName());
        T a11 = a();
        Log.b("CallBacker", "call() end  cost:" + (System.currentTimeMillis() - currentTimeMillis) + "  result=" + a11);
        return a11;
    }
}
