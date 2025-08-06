package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioStream.a f6052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f6053c;

    public /* synthetic */ p(AudioStream.a aVar, boolean z11) {
        this.f6052b = aVar;
        this.f6053c = z11;
    }

    public final void run() {
        this.f6052b.a(this.f6053c);
    }
}
