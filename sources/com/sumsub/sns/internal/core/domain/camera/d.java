package com.sumsub.sns.internal.core.domain.camera;

import android.graphics.Matrix;
import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.o;

public final /* synthetic */ class d implements ImageAnalysis.Analyzer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f33567a;

    public /* synthetic */ d(CameraX cameraX) {
        this.f33567a = cameraX;
    }

    public final void analyze(ImageProxy imageProxy) {
        CameraX.a(this.f33567a, imageProxy);
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
