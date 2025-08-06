package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidImageReaderProxy f5498b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f5499c;

    public /* synthetic */ b(AndroidImageReaderProxy androidImageReaderProxy, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f5498b = androidImageReaderProxy;
        this.f5499c = onImageAvailableListener;
    }

    public final void run() {
        this.f5498b.lambda$setOnImageAvailableListener$0(this.f5499c);
    }
}
