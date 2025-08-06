package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioSource;
import java.util.concurrent.Executor;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSource f6049b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f6050c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f6051d;

    public /* synthetic */ m(AudioSource audioSource, Executor executor, AudioSource.d dVar) {
        this.f6049b = audioSource;
        this.f6050c = executor;
        this.f6051d = dVar;
    }

    public final void run() {
        this.f6049b.x(this.f6050c, this.f6051d);
    }
}
