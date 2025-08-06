package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.camera.video.internal.encoder.k;

public final /* synthetic */ class a1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k.c.a f6158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Surface f6159c;

    public /* synthetic */ a1(k.c.a aVar, Surface surface) {
        this.f6158b = aVar;
        this.f6159c = surface;
    }

    public final void run() {
        this.f6158b.a(this.f6159c);
    }
}
