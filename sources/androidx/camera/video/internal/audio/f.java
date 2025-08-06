package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f6036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Throwable f6037c;

    public /* synthetic */ f(AudioSource.d dVar, Throwable th2) {
        this.f6036b = dVar;
        this.f6037c = th2;
    }

    public final void run() {
        this.f6036b.onError(this.f6037c);
    }
}
