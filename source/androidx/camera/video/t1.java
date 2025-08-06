package androidx.camera.video;

import android.view.Surface;

public final /* synthetic */ class t1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6355b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f6356c;

    public /* synthetic */ t1(VideoEncoderSession videoEncoderSession, Surface surface) {
        this.f6355b = videoEncoderSession;
        this.f6356c = surface;
    }

    public final void run() {
        this.f6355b.r(this.f6356c);
    }
}
