package androidx.camera.extensions.internal.sessionprocessor;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class e implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StillCaptureProcessor f5778a;

    public /* synthetic */ e(StillCaptureProcessor stillCaptureProcessor) {
        this.f5778a = stillCaptureProcessor;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5778a.lambda$new$0(imageReaderProxy);
    }
}
