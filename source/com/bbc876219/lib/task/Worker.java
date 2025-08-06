package com.bbc876219.lib.task;

import android.os.Process;
import android.util.Log;

public abstract class Worker<T> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public int f63247b = 10;

    public abstract void a();

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        Process.setThreadPriority(this.f63247b);
        Log.d("Worker", "call() start  " + getClass().getName());
        a();
        Log.d("Worker", "call() end  cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
