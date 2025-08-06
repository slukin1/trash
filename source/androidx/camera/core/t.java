package androidx.camera.core;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysisNonBlockingAnalyzer f5720b;

    public /* synthetic */ t(ImageAnalysisNonBlockingAnalyzer imageAnalysisNonBlockingAnalyzer) {
        this.f5720b = imageAnalysisNonBlockingAnalyzer;
    }

    public final void run() {
        this.f5720b.analyzeCachedImage();
    }
}
