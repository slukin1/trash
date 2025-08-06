package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class i0 implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MetadataImageReader f5521a;

    public /* synthetic */ i0(MetadataImageReader metadataImageReader) {
        this.f5521a = metadataImageReader;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5521a.lambda$new$0(imageReaderProxy);
    }
}
