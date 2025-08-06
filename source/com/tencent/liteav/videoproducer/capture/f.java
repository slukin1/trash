package com.tencent.liteav.videoproducer.capture;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualDisplayManager f22604a;

    private f(VirtualDisplayManager virtualDisplayManager) {
        this.f22604a = virtualDisplayManager;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager) {
        return new f(virtualDisplayManager);
    }

    public final void run() {
        this.f22604a.a(false);
    }
}
