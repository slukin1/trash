package com.tencent.liteav.base;

import android.os.StrictMode;
import java.io.Closeable;

public final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final StrictMode.ThreadPolicy f21405a;

    /* renamed from: b  reason: collision with root package name */
    private final StrictMode.VmPolicy f21406b;

    private b(StrictMode.ThreadPolicy threadPolicy) {
        this.f21405a = threadPolicy;
        this.f21406b = null;
    }

    public static b a() {
        return new b(StrictMode.allowThreadDiskWrites(), (byte) 0);
    }

    public final void close() {
        StrictMode.ThreadPolicy threadPolicy = this.f21405a;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.f21406b;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    private b(StrictMode.ThreadPolicy threadPolicy, byte b11) {
        this(threadPolicy);
    }
}
