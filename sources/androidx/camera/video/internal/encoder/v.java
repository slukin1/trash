package androidx.camera.video.internal.encoder;

import java.util.List;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f6271b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f6272c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f6273d;

    public /* synthetic */ v(EncoderImpl encoderImpl, List list, Runnable runnable) {
        this.f6271b = encoderImpl;
        this.f6272c = list;
        this.f6273d = runnable;
    }

    public final void run() {
        this.f6271b.W(this.f6272c, this.f6273d);
    }
}
