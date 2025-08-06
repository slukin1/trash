package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.concurrent.Executor;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f5246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f5247c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5248d;

    public /* synthetic */ p(u uVar, Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.f5246b = uVar;
        this.f5247c = executor;
        this.f5248d = cameraCaptureCallback;
    }

    public final void run() {
        this.f5246b.I(this.f5247c, this.f5248d);
    }
}
