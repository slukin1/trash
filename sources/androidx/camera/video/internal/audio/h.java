package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f6040b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f6041c;

    public /* synthetic */ h(AudioSource.d dVar, boolean z11) {
        this.f6040b = dVar;
        this.f6041c = z11;
    }

    public final void run() {
        this.f6040b.a(this.f6041c);
    }
}
