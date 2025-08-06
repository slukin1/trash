package androidx.camera.core;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5623b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5624c;

    public /* synthetic */ n(SafeCloseImageReaderProxy safeCloseImageReaderProxy, SafeCloseImageReaderProxy safeCloseImageReaderProxy2) {
        this.f5623b = safeCloseImageReaderProxy;
        this.f5624c = safeCloseImageReaderProxy2;
    }

    public final void run() {
        ImageAnalysis.lambda$createPipeline$0(this.f5623b, this.f5624c);
    }
}
