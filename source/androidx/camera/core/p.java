package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageAnalysis;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysisAbstractAnalyzer f5629a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f5630b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5631c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f5632d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5633e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Rect f5634f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysis.Analyzer f5635g;

    public /* synthetic */ p(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer) {
        this.f5629a = imageAnalysisAbstractAnalyzer;
        this.f5630b = executor;
        this.f5631c = imageProxy;
        this.f5632d = matrix;
        this.f5633e = imageProxy2;
        this.f5634f = rect;
        this.f5635g = analyzer;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5629a.lambda$analyzeImage$1(this.f5630b, this.f5631c, this.f5632d, this.f5633e, this.f5634f, this.f5635g, aVar);
    }
}
