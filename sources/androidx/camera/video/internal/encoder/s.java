package androidx.camera.video.internal.encoder;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f6261c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f6262d;

    public /* synthetic */ s(EncoderImpl encoderImpl, long j11, long j12) {
        this.f6260b = encoderImpl;
        this.f6261c = j11;
        this.f6262d = j12;
    }

    public final void run() {
        this.f6260b.V(this.f6261c, this.f6262d);
    }
}
