package androidx.camera.video;

import androidx.camera.video.internal.encoder.k;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f5939b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f5940c;

    public /* synthetic */ e0(Recorder recorder, k kVar) {
        this.f5939b = recorder;
        this.f5940c = kVar;
    }

    public final void run() {
        this.f5939b.Q(this.f5940c);
    }
}
