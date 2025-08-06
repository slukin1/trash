package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.u;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g implements u.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f5115a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5116b;

    public /* synthetic */ g(long j11, CallbackToFutureAdapter.a aVar) {
        this.f5115a = j11;
        this.f5116b = aVar;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return u.P(this.f5115a, this.f5116b, totalCaptureResult);
    }
}
