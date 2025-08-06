package com.tencent.liteav.videoproducer.capture;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualDisplayManager f22615a;

    private j(VirtualDisplayManager virtualDisplayManager) {
        this.f22615a = virtualDisplayManager;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager) {
        return new j(virtualDisplayManager);
    }

    public final void run() {
        VirtualDisplayManager.c(this.f22615a);
    }
}
