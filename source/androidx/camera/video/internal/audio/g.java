package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f6038b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f6039c;

    public /* synthetic */ g(AudioSource.d dVar, boolean z11) {
        this.f6038b = dVar;
        this.f6039c = z11;
    }

    public final void run() {
        this.f6038b.c(this.f6039c);
    }
}
