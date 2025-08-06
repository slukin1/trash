package androidx.camera.video.internal.encoder;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f1 f6265c;

    public /* synthetic */ t(EncoderImpl encoderImpl, f1 f1Var) {
        this.f6264b = encoderImpl;
        this.f6265c = f1Var;
    }

    public final void run() {
        this.f6264b.L(this.f6265c);
    }
}
