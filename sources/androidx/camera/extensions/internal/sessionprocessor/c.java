package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor;
import androidx.camera.extensions.internal.sessionprocessor.a;

public final /* synthetic */ class c implements a.C0008a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewProcessor f5776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreviewProcessor.OnCaptureResultCallback f5777b;

    public /* synthetic */ c(PreviewProcessor previewProcessor, PreviewProcessor.OnCaptureResultCallback onCaptureResultCallback) {
        this.f5776a = previewProcessor;
        this.f5777b = onCaptureResultCallback;
    }

    public final void a(b bVar, TotalCaptureResult totalCaptureResult, int i11) {
        this.f5776a.lambda$start$0(this.f5777b, bVar, totalCaptureResult, i11);
    }
}
