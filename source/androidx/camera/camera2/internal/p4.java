package androidx.camera.camera2.internal;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class p4 implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s4 f5274a;

    public /* synthetic */ p4(s4 s4Var) {
        this.f5274a = s4Var;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f5274a.k(imageReaderProxy);
    }
}
