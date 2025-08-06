package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;
import java.util.concurrent.Executor;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f6082b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioStream.a f6083c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Executor f6084d;

    public /* synthetic */ z(a0 a0Var, AudioStream.a aVar, Executor executor) {
        this.f6082b = a0Var;
        this.f6083c = aVar;
        this.f6084d = executor;
    }

    public final void run() {
        this.f6082b.l(this.f6083c, this.f6084d);
    }
}
