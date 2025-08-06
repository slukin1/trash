package androidx.camera.camera2.internal;

import androidx.camera.core.SafeCloseImageReaderProxy;

public final /* synthetic */ class r4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5294b;

    public /* synthetic */ r4(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.f5294b = safeCloseImageReaderProxy;
    }

    public final void run() {
        this.f5294b.safeClose();
    }
}
