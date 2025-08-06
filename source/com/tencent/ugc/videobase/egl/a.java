package com.tencent.ugc.videobase.egl;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final EGLContextChecker f50842a;

    private a(EGLContextChecker eGLContextChecker) {
        this.f50842a = eGLContextChecker;
    }

    public static Runnable a(EGLContextChecker eGLContextChecker) {
        return new a(eGLContextChecker);
    }

    public final void run() {
        this.f50842a.uninitGLComponents();
    }
}
