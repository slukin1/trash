package androidx.camera.core.impl;

import java.util.List;

public interface RequestProcessor {

    public interface Callback {
        void onCaptureBufferLost(Request request, long j11, int i11);

        void onCaptureCompleted(Request request, CameraCaptureResult cameraCaptureResult);

        void onCaptureFailed(Request request, CameraCaptureFailure cameraCaptureFailure);

        void onCaptureProgressed(Request request, CameraCaptureResult cameraCaptureResult);

        void onCaptureSequenceAborted(int i11);

        void onCaptureSequenceCompleted(int i11, long j11);

        void onCaptureStarted(Request request, long j11, long j12);
    }

    public interface Request {
        Config getParameters();

        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(Request request, Callback callback);

    void stopRepeating();

    int submit(Request request, Callback callback);

    int submit(List<Request> list, Callback callback);
}
