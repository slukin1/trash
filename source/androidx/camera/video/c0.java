package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f5922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Recorder.i f5923c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5924d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f5925e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f5926f;

    public /* synthetic */ c0(Recorder recorder, Recorder.i iVar, long j11, int i11, Throwable th2) {
        this.f5922b = recorder;
        this.f5923c = iVar;
        this.f5924d = j11;
        this.f5925e = i11;
        this.f5926f = th2;
    }

    public final void run() {
        this.f5922b.O(this.f5923c, this.f5924d, this.f5925e, this.f5926f);
    }
}
