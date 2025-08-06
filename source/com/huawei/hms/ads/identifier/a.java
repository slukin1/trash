package com.huawei.hms.ads.identifier;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f37756a = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: b  reason: collision with root package name */
    public boolean f37757b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f37758c = new LinkedBlockingQueue<>(1);

    public IBinder a() throws InterruptedException {
        if (!this.f37757b) {
            this.f37757b = true;
            return this.f37758c.take();
        }
        throw new IllegalStateException();
    }

    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.d("PPSSerivceConnection", "onServiceConnected");
        f37756a.execute(new Runnable() {
            public void run() {
                try {
                    Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
                    a.this.f37758c.offer(iBinder);
                } catch (Throwable th2) {
                    Log.w("PPSSerivceConnection", "onServiceConnected  " + th2.getClass().getSimpleName());
                }
            }
        });
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
