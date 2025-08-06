package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;

public interface VideoOutput {

    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    void a(SurfaceRequest surfaceRequest, Timebase timebase);

    Observable<r> b();

    Observable<StreamInfo> c();

    void d(SourceState sourceState);

    c1 e(CameraInfo cameraInfo);

    void onSurfaceRequested(SurfaceRequest surfaceRequest);
}
