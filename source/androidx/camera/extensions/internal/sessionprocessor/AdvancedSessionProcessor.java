package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.impl.advanced.ImageProcessorImpl;
import androidx.camera.extensions.impl.advanced.ImageReferenceImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceImpl;
import androidx.camera.extensions.impl.advanced.RequestProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import n.a;

public class AdvancedSessionProcessor extends d {

    public static class CallbackAdapter implements RequestProcessor.Callback {
        private final RequestProcessorImpl.Callback mCallback;

        public CallbackAdapter(RequestProcessorImpl.Callback callback) {
            this.mCallback = callback;
        }

        private RequestProcessorImpl.Request getImplRequest(RequestProcessor.Request request) {
            h.a(request instanceof RequestAdapter);
            return ((RequestAdapter) request).getImplRequest();
        }

        public void onCaptureBufferLost(RequestProcessor.Request request, long j11, int i11) {
            this.mCallback.onCaptureBufferLost(getImplRequest(request), j11, i11);
        }

        public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
            CaptureResult b11 = a.b(cameraCaptureResult);
            h.b(b11 instanceof TotalCaptureResult, "CaptureResult in cameraCaptureResult is not a TotalCaptureResult");
            this.mCallback.onCaptureCompleted(getImplRequest(request), (TotalCaptureResult) b11);
        }

        public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
            CaptureFailure a11 = a.a(cameraCaptureFailure);
            h.b(a11 != null, "CameraCaptureFailure does not contain CaptureFailure.");
            this.mCallback.onCaptureFailed(getImplRequest(request), a11);
        }

        public void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
            CaptureResult b11 = a.b(cameraCaptureResult);
            h.b(b11 != null, "Cannot get CaptureResult from the cameraCaptureResult ");
            this.mCallback.onCaptureProgressed(getImplRequest(request), b11);
        }

        public void onCaptureSequenceAborted(int i11) {
            this.mCallback.onCaptureSequenceAborted(i11);
        }

        public void onCaptureSequenceCompleted(int i11, long j11) {
            this.mCallback.onCaptureSequenceCompleted(i11, j11);
        }

        public void onCaptureStarted(RequestProcessor.Request request, long j11, long j12) {
            this.mCallback.onCaptureStarted(getImplRequest(request), j11, j12);
        }
    }

    public static class ImageProcessorAdapter {
        private final ImageProcessorImpl mImpl;

        public ImageProcessorAdapter(ImageProcessorImpl imageProcessorImpl) {
            this.mImpl = imageProcessorImpl;
        }

        public void onNextImageAvailable(int i11, long j11, b bVar, String str) {
            this.mImpl.onNextImageAvailable(i11, j11, new ImageReferenceImplAdapter(bVar), str);
        }
    }

    public static class ImageReferenceImplAdapter implements ImageReferenceImpl {
        private final b mImageReference;

        public ImageReferenceImplAdapter(b bVar) {
            this.mImageReference = bVar;
        }

        public boolean decrement() {
            return this.mImageReference.a();
        }

        public Image get() {
            return this.mImageReference.get();
        }

        public boolean increment() {
            return this.mImageReference.increment();
        }
    }

    public static class OutputSurfaceImplAdapter implements OutputSurfaceImpl {
        private final OutputSurface mOutputSurface;

        public OutputSurfaceImplAdapter(OutputSurface outputSurface) {
            this.mOutputSurface = outputSurface;
        }

        public int getImageFormat() {
            return this.mOutputSurface.getImageFormat();
        }

        public Size getSize() {
            return this.mOutputSurface.getSize();
        }

        public Surface getSurface() {
            return this.mOutputSurface.getSurface();
        }
    }

    public static class RequestAdapter implements RequestProcessor.Request {
        private final RequestProcessorImpl.Request mImplRequest;
        private final Config mParameters;
        private final List<Integer> mTargetOutputConfigIds;
        private final int mTemplateId;

        public RequestAdapter(RequestProcessorImpl.Request request) {
            this.mImplRequest = request;
            ArrayList arrayList = new ArrayList();
            for (Integer add : request.getTargetOutputConfigIds()) {
                arrayList.add(add);
            }
            this.mTargetOutputConfigIds = arrayList;
            Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
            for (CaptureRequest.Key key : request.getParameters().keySet()) {
                builder.c(key, request.getParameters().get(key));
            }
            this.mParameters = builder.build();
            this.mTemplateId = request.getTemplateId().intValue();
        }

        public RequestProcessorImpl.Request getImplRequest() {
            return this.mImplRequest;
        }

        public Config getParameters() {
            return this.mParameters;
        }

        public List<Integer> getTargetOutputConfigIds() {
            return this.mTargetOutputConfigIds;
        }

        public int getTemplateId() {
            return this.mTemplateId;
        }
    }

    public class RequestProcessorImplAdapter implements RequestProcessorImpl {
        private final RequestProcessor mRequestProcessor;
        public final /* synthetic */ AdvancedSessionProcessor this$0;

        public RequestProcessorImplAdapter(AdvancedSessionProcessor advancedSessionProcessor, RequestProcessor requestProcessor) {
            this.mRequestProcessor = requestProcessor;
        }

        public void abortCaptures() {
            this.mRequestProcessor.abortCaptures();
        }

        public void setImageProcessor(int i11, ImageProcessorImpl imageProcessorImpl) {
            new ImageProcessorAdapter(imageProcessorImpl);
            throw null;
        }

        public int setRepeating(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.setRepeating(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public void stopRepeating() {
            this.mRequestProcessor.stopRepeating();
        }

        public int submit(RequestProcessorImpl.Request request, RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.submit((RequestProcessor.Request) new RequestAdapter(request), (RequestProcessor.Callback) new CallbackAdapter(callback));
        }

        public int submit(List<RequestProcessorImpl.Request> list, RequestProcessorImpl.Callback callback) {
            ArrayList arrayList = new ArrayList();
            for (RequestProcessorImpl.Request requestAdapter : list) {
                arrayList.add(new RequestAdapter(requestAdapter));
            }
            return this.mRequestProcessor.submit((List<RequestProcessor.Request>) arrayList, (RequestProcessor.Callback) new CallbackAdapter(callback));
        }
    }

    public static class SessionProcessorImplCaptureCallbackAdapter implements SessionProcessorImpl.CaptureCallback {
        private final SessionProcessor.CaptureCallback mCaptureCallback;

        public SessionProcessorImplCaptureCallbackAdapter(SessionProcessor.CaptureCallback captureCallback) {
            this.mCaptureCallback = captureCallback;
        }

        public void onCaptureCompleted(long j11, int i11, Map<CaptureResult.Key, Object> map) {
            this.mCaptureCallback.onCaptureCompleted(j11, i11, map);
        }

        public void onCaptureFailed(int i11) {
            this.mCaptureCallback.onCaptureFailed(i11);
        }

        public void onCaptureProcessProgressed(int i11) {
        }

        public void onCaptureProcessStarted(int i11) {
            this.mCaptureCallback.onCaptureProcessStarted(i11);
        }

        public void onCaptureSequenceAborted(int i11) {
            this.mCaptureCallback.onCaptureSequenceAborted(i11);
        }

        public void onCaptureSequenceCompleted(int i11) {
            this.mCaptureCallback.onCaptureSequenceCompleted(i11);
        }

        public void onCaptureStarted(int i11, long j11) {
            this.mCaptureCallback.onCaptureStarted(i11, j11);
        }
    }
}
