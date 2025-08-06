package com.tencent.thumbplayer.tcmedia.utils;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private Object f49697a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f49698b = false;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f49699c = null;

    private void b(long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z11 = false;
        while (j11 > 0) {
            try {
                wait(j11);
                break;
            } catch (InterruptedException unused) {
                z11 = true;
                j11 -= System.currentTimeMillis() - currentTimeMillis;
                TPLogUtil.i("TPFutureResult", "getResult wait has InterruptedException, remainTime:".concat(String.valueOf(j11)));
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized Object a(long j11) {
        if (!this.f49698b) {
            b(j11);
        }
        Throwable th2 = this.f49699c;
        if (th2 == null) {
        } else {
            throw th2;
        }
        return this.f49697a;
    }

    public synchronized void a(Object obj) {
        if (!this.f49698b) {
            this.f49697a = obj;
            this.f49698b = true;
            notifyAll();
        }
    }

    public synchronized void a(Throwable th2) {
        if (th2 != null) {
            this.f49699c = th2;
            this.f49698b = true;
            notifyAll();
        }
    }
}
