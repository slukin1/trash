package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f6269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaFormat f6270c;

    public /* synthetic */ u0(m mVar, MediaFormat mediaFormat) {
        this.f6269b = mVar;
        this.f6270c = mediaFormat;
    }

    public final void run() {
        this.f6269b.d(new p0(this.f6270c));
    }
}
