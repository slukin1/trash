package androidx.camera.video;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.SessionConfig;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class i1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f5973b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.Builder f5974c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5975d;

    public /* synthetic */ i1(AtomicBoolean atomicBoolean, SessionConfig.Builder builder, CameraCaptureCallback cameraCaptureCallback) {
        this.f5973b = atomicBoolean;
        this.f5974c = builder;
        this.f5975d = cameraCaptureCallback;
    }

    public final void run() {
        VideoCapture.L(this.f5973b, this.f5974c, this.f5975d);
    }
}
