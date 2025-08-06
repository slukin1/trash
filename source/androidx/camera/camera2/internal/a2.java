package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class a2 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f5002a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f5003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f5004c;

    public /* synthetic */ a2(CaptureSession captureSession, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        this.f5002a = captureSession;
        this.f5003b = sessionConfig;
        this.f5004c = cameraDevice;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5002a.t(this.f5003b, this.f5004c, (List) obj);
    }
}
