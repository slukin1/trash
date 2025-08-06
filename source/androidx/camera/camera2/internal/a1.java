package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.x0;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class a1 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0.c f5000a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5001b;

    public /* synthetic */ a1(x0.c cVar, int i11) {
        this.f5000a = cVar;
        this.f5001b = i11;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5000a.j(this.f5001b, (TotalCaptureResult) obj);
    }
}
