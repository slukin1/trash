package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MetadataImageReader f5605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageReaderProxy.OnImageAvailableListener f5606c;

    public /* synthetic */ j0(MetadataImageReader metadataImageReader, ImageReaderProxy.OnImageAvailableListener onImageAvailableListener) {
        this.f5605b = metadataImageReader;
        this.f5606c = onImageAvailableListener;
    }

    public final void run() {
        this.f5605b.lambda$enqueueImageProxy$1(this.f5606c);
    }
}
