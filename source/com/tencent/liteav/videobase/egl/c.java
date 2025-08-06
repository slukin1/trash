package com.tencent.liteav.videobase.egl;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final EGLCore f22189a;

    private c(EGLCore eGLCore) {
        this.f22189a = eGLCore;
    }

    public static Runnable a(EGLCore eGLCore) {
        return new c(eGLCore);
    }

    public final void run() {
        EGLCore.lambda$destroy$0(this.f22189a);
    }
}
