package com.tencent.ugc.videobase.egl;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final EGLCore f50845a;

    private c(EGLCore eGLCore) {
        this.f50845a = eGLCore;
    }

    public static Runnable a(EGLCore eGLCore) {
        return new c(eGLCore);
    }

    public final void run() {
        EGLCore.lambda$destroy$0(this.f50845a);
    }
}
