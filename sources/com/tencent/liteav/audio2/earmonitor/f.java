package com.tencent.liteav.audio2.earmonitor;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21379a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21380b;

    private f(a aVar, int i11) {
        this.f21379a = aVar;
        this.f21380b = i11;
    }

    public static Runnable a(a aVar, int i11) {
        return new f(aVar, i11);
    }

    public final void run() {
        a.b(this.f21379a, this.f21380b);
    }
}
