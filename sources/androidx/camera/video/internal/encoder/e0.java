package androidx.camera.video.internal.encoder;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6200c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f6201d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f6202e;

    public /* synthetic */ e0(EncoderImpl encoderImpl, int i11, String str, Throwable th2) {
        this.f6199b = encoderImpl;
        this.f6200c = i11;
        this.f6201d = str;
        this.f6202e = th2;
    }

    public final void run() {
        this.f6199b.K(this.f6200c, this.f6201d, this.f6202e);
    }
}
