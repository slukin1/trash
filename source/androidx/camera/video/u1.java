package androidx.camera.video;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoOutput;

public final /* synthetic */ class u1 {
    public static c1 a(VideoOutput videoOutput, CameraInfo cameraInfo) {
        return c1.f5927a;
    }

    public static Observable b(VideoOutput videoOutput) {
        return ConstantObservable.withValue(null);
    }

    public static Observable c(VideoOutput videoOutput) {
        return StreamInfo.f5855c;
    }

    public static void d(VideoOutput videoOutput, VideoOutput.SourceState sourceState) {
    }

    public static void e(VideoOutput videoOutput, SurfaceRequest surfaceRequest, Timebase timebase) {
        videoOutput.onSurfaceRequested(surfaceRequest);
    }
}
