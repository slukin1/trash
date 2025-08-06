package com.huawei.hms.adapter.sysobs;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;

public class ApkResolutionFailedManager {

    /* renamed from: c  reason: collision with root package name */
    private static final ApkResolutionFailedManager f37734c = new ApkResolutionFailedManager();

    /* renamed from: a  reason: collision with root package name */
    private final Handler f37735a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Runnable> f37736b = new HashMap(2);

    private ApkResolutionFailedManager() {
    }

    public static ApkResolutionFailedManager getInstance() {
        return f37734c;
    }

    public void postTask(String str, Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "postTask is not in main thread");
            return;
        }
        this.f37736b.put(str, runnable);
        this.f37735a.postDelayed(runnable, 2000);
    }

    public void removeTask(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeTask is not in main thread");
            return;
        }
        Runnable remove = this.f37736b.remove(str);
        if (remove == null) {
            HMSLog.e("ApkResolutionFailedManager", "cancel runnable is null");
        } else {
            this.f37735a.removeCallbacks(remove);
        }
    }

    public void removeValueOnly(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HMSLog.e("ApkResolutionFailedManager", "removeValueOnly is not in main thread");
        } else {
            this.f37736b.remove(str);
        }
    }
}
