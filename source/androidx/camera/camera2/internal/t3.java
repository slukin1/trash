package androidx.camera.camera2.internal;

public final /* synthetic */ class t3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v3 f5331b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSession f5332c;

    public /* synthetic */ t3(v3 v3Var, SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f5331b = v3Var;
        this.f5332c = synchronizedCaptureSession;
    }

    public final void run() {
        this.f5331b.D(this.f5332c);
    }
}
