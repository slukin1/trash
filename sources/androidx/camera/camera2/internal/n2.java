package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.u;

public final /* synthetic */ class n2 implements u.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x2 f5227a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5228b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5229c;

    public /* synthetic */ n2(x2 x2Var, int i11, long j11) {
        this.f5227a = x2Var;
        this.f5228b = i11;
        this.f5229c = j11;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return this.f5227a.G(this.f5228b, this.f5229c, totalCaptureResult);
    }
}
