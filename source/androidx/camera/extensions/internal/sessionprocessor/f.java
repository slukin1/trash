package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor;
import androidx.camera.extensions.internal.sessionprocessor.a;
import java.util.List;

public final /* synthetic */ class f implements a.C0008a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StillCaptureProcessor f5779a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ StillCaptureProcessor.OnCaptureResultCallback f5781c;

    public /* synthetic */ f(StillCaptureProcessor stillCaptureProcessor, List list, StillCaptureProcessor.OnCaptureResultCallback onCaptureResultCallback) {
        this.f5779a = stillCaptureProcessor;
        this.f5780b = list;
        this.f5781c = onCaptureResultCallback;
    }

    public final void a(b bVar, TotalCaptureResult totalCaptureResult, int i11) {
        this.f5779a.lambda$startCapture$1(this.f5780b, this.f5781c, bVar, totalCaptureResult, i11);
    }
}
