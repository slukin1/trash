package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class w0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f6277b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f6278c;

    public /* synthetic */ w0(EncoderImpl.e eVar, int i11) {
        this.f6277b = eVar;
        this.f6278c = i11;
    }

    public final void run() {
        this.f6277b.m(this.f6278c);
    }
}
