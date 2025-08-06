package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class g3 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessingCaptureSession f5128a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionConfig f5129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f5130c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b4 f5131d;

    public /* synthetic */ g3(ProcessingCaptureSession processingCaptureSession, SessionConfig sessionConfig, CameraDevice cameraDevice, b4 b4Var) {
        this.f5128a = processingCaptureSession;
        this.f5129b = sessionConfig;
        this.f5130c = cameraDevice;
        this.f5131d = b4Var;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5128a.t(this.f5129b, this.f5130c, this.f5131d, (List) obj);
    }
}
