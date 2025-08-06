package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.u;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u.b f5368b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TotalCaptureResult f5369c;

    public /* synthetic */ v(u.b bVar, TotalCaptureResult totalCaptureResult) {
        this.f5368b = bVar;
        this.f5369c = totalCaptureResult;
    }

    public final void run() {
        this.f5368b.c(this.f5369c);
    }
}
