package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.BufferProvider;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BufferProvider f6044c;

    public /* synthetic */ j(AudioSource audioSource, BufferProvider bufferProvider) {
        this.f6043b = audioSource;
        this.f6044c = bufferProvider;
    }

    public final void run() {
        this.f6043b.y(this.f6044c);
    }
}
