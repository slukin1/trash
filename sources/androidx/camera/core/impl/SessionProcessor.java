package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import android.util.Pair;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.RestrictedCameraControl;
import java.util.Map;
import java.util.Set;

public interface SessionProcessor {

    public interface CaptureCallback {
        void onCaptureCompleted(long j11, int i11, Map<CaptureResult.Key, Object> map);

        void onCaptureFailed(int i11);

        void onCaptureProcessStarted(int i11);

        void onCaptureSequenceAborted(int i11);

        void onCaptureSequenceCompleted(int i11);

        void onCaptureStarted(int i11, long j11);
    }

    void abortCapture(int i11);

    void deInitSession();

    Pair<Long, Long> getRealtimeCaptureLatency();

    @RestrictedCameraControl.CameraOperation
    Set<Integer> getSupportedCameraOperations();

    SessionConfig initSession(CameraInfo cameraInfo, OutputSurface outputSurface, OutputSurface outputSurface2, OutputSurface outputSurface3);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(RequestProcessor requestProcessor);

    void setParameters(Config config);

    int startCapture(CaptureCallback captureCallback);

    int startRepeating(CaptureCallback captureCallback);

    int startTrigger(Config config, CaptureCallback captureCallback);

    void stopRepeating();
}
