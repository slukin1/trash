package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.u;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i2 implements u.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5157b;

    public /* synthetic */ i2(int i11, CallbackToFutureAdapter.a aVar) {
        this.f5156a = i11;
        this.f5157b = aVar;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return l2.g(this.f5156a, this.f5157b, totalCaptureResult);
    }
}
