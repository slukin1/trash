package androidx.camera.video.internal.encoder;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6252b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f6253c;

    public /* synthetic */ q(EncoderImpl encoderImpl, long j11) {
        this.f6252b = encoderImpl;
        this.f6253c = j11;
    }

    public final void run() {
        this.f6252b.S(this.f6253c);
    }
}
