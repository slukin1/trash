package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.u;

public final /* synthetic */ class o2 implements u.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x2 f5240a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5241b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f5242c;

    public /* synthetic */ o2(x2 x2Var, boolean z11, long j11) {
        this.f5240a = x2Var;
        this.f5241b = z11;
        this.f5242c = j11;
    }

    public final boolean a(TotalCaptureResult totalCaptureResult) {
        return this.f5240a.H(this.f5241b, this.f5242c, totalCaptureResult);
    }
}
