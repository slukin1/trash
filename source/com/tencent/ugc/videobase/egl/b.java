package com.tencent.ugc.videobase.egl;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final EGLContextChecker f50843a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f50844b;

    private b(EGLContextChecker eGLContextChecker, Object obj) {
        this.f50843a = eGLContextChecker;
        this.f50844b = obj;
    }

    public static Runnable a(EGLContextChecker eGLContextChecker, Object obj) {
        return new b(eGLContextChecker, obj);
    }

    public final void run() {
        EGLContextChecker.lambda$recreateShader$0(this.f50843a, this.f50844b);
    }
}
