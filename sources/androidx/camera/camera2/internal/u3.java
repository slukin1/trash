package androidx.camera.camera2.internal;

public final /* synthetic */ class u3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v3 f5366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSession f5367c;

    public /* synthetic */ u3(v3 v3Var, SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f5366b = v3Var;
        this.f5367c = synchronizedCaptureSession;
    }

    public final void run() {
        this.f5366b.C(this.f5367c);
    }
}
