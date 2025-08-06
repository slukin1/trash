package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer f5703b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5704c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f5705d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5706e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Rect f5707f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysis.Analyzer f5708g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5709h;

    public /* synthetic */ q(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.a aVar) {
        this.f5703b = imageAnalysisAbstractAnalyzer;
        this.f5704c = imageProxy;
        this.f5705d = matrix;
        this.f5706e = imageProxy2;
        this.f5707f = rect;
        this.f5708g = analyzer;
        this.f5709h = aVar;
    }

    public final void run() {
        this.f5703b.lambda$analyzeImage$0(this.f5704c, this.f5705d, this.f5706e, this.f5707f, this.f5708g, this.f5709h);
    }
}
