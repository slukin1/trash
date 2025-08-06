package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k f22461a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22462b;

    private n(k kVar, boolean z11) {
        this.f22461a = kVar;
        this.f22462b = z11;
    }

    public static Runnable a(k kVar, boolean z11) {
        return new n(kVar, z11);
    }

    public final void run() {
        k.a(this.f22461a, this.f22462b);
    }
}
