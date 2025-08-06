package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f6254b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f6255c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f6256d;

    public /* synthetic */ q0(EncoderImpl.e eVar, Executor executor, m mVar) {
        this.f6254b = eVar;
        this.f6255c = executor;
        this.f6256d = mVar;
    }

    public final void run() {
        this.f6254b.n(this.f6255c, this.f6256d);
    }
}
