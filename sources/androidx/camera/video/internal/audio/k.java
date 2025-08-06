package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f6046c;

    public /* synthetic */ k(AudioSource audioSource, AudioSource.d dVar) {
        this.f6045b = audioSource;
        this.f6046c = dVar;
    }

    public final void run() {
        this.f6045b.u(this.f6046c);
    }
}
