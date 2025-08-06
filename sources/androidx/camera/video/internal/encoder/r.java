package androidx.camera.video.internal.encoder;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6257b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f6258c;

    public /* synthetic */ r(EncoderImpl encoderImpl, long j11) {
        this.f6257b = encoderImpl;
        this.f6258c = j11;
    }

    public final void run() {
        this.f6257b.O(this.f6258c);
    }
}
