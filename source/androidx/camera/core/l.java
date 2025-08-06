package androidx.camera.core;

import android.graphics.Matrix;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;

public final /* synthetic */ class l implements ImageAnalysis.Analyzer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageAnalysis.Analyzer f5615a;

    public /* synthetic */ l(ImageAnalysis.Analyzer analyzer) {
        this.f5615a = analyzer;
    }

    public final void analyze(ImageProxy imageProxy) {
        this.f5615a.analyze(imageProxy);
    }

    public /* synthetic */ Size getDefaultTargetResolution() {
        return o.a(this);
    }

    public /* synthetic */ int getTargetCoordinateSystem() {
        return o.b(this);
    }

    public /* synthetic */ void updateTransform(Matrix matrix) {
        o.c(this, matrix);
    }
}
