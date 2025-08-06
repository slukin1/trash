package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;

public interface c2 {
    ListenableFuture<Void> a(boolean z11);

    void b(SessionConfig sessionConfig);

    void c(List<CaptureConfig> list);

    void close();

    void d();

    List<CaptureConfig> e();

    ListenableFuture<Void> f(SessionConfig sessionConfig, CameraDevice cameraDevice, b4 b4Var);

    void g(Map<DeferrableSurface, Long> map);

    SessionConfig getSessionConfig();
}
