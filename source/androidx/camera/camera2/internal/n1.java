package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.TagBundle;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class n1 implements RequestProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final CaptureSession f5219a;

    /* renamed from: b  reason: collision with root package name */
    public final List<SessionProcessorSurface> f5220b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f5221c = false;

    /* renamed from: d  reason: collision with root package name */
    public volatile SessionConfig f5222d;

    public class a extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final RequestProcessor.Callback f5223a;

        /* renamed from: b  reason: collision with root package name */
        public final RequestProcessor.Request f5224b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5225c;

        public a(RequestProcessor.Request request, RequestProcessor.Callback callback, boolean z11) {
            this.f5223a = callback;
            this.f5224b = request;
            this.f5225c = z11;
        }

        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j11) {
            this.f5223a.onCaptureBufferLost(this.f5224b, j11, n1.this.c(surface));
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f5223a.onCaptureCompleted(this.f5224b, new f(totalCaptureResult));
        }

        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.f5223a.onCaptureFailed(this.f5224b, new e(CameraCaptureFailure.Reason.ERROR, captureFailure));
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.f5223a.onCaptureProgressed(this.f5224b, new f(captureResult));
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i11) {
            if (this.f5225c) {
                this.f5223a.onCaptureSequenceAborted(i11);
            }
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i11, long j11) {
            if (this.f5225c) {
                this.f5223a.onCaptureSequenceCompleted(i11, j11);
            }
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
            this.f5223a.onCaptureStarted(this.f5224b, j12, j11);
        }
    }

    public n1(CaptureSession captureSession, List<SessionProcessorSurface> list) {
        boolean z11 = false;
        z11 = captureSession.f4955l == CaptureSession.State.OPENED ? true : z11;
        h.b(z11, "CaptureSession state must be OPENED. Current state:" + captureSession.f4955l);
        this.f5219a = captureSession;
        this.f5220b = Collections.unmodifiableList(new ArrayList(list));
    }

    public final boolean a(List<RequestProcessor.Request> list) {
        for (RequestProcessor.Request e11 : list) {
            if (!e(e11)) {
                return false;
            }
        }
        return true;
    }

    public void abortCaptures() {
        if (!this.f5221c) {
            this.f5219a.k();
        }
    }

    public void b() {
        this.f5221c = true;
    }

    public int c(Surface surface) {
        for (SessionProcessorSurface next : this.f5220b) {
            try {
                if (next.getSurface().get() == surface) {
                    return next.getOutputConfigId();
                }
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return -1;
    }

    public final DeferrableSurface d(int i11) {
        for (SessionProcessorSurface next : this.f5220b) {
            if (next.getOutputConfigId() == i11) {
                return next;
            }
        }
        return null;
    }

    public final boolean e(RequestProcessor.Request request) {
        if (request.getTargetOutputConfigIds().isEmpty()) {
            Logger.e("Camera2RequestProcessor", "Unable to submit the RequestProcessor.Request: empty targetOutputConfigIds");
            return false;
        }
        for (Integer next : request.getTargetOutputConfigIds()) {
            if (d(next.intValue()) == null) {
                Logger.e("Camera2RequestProcessor", "Unable to submit the RequestProcessor.Request: targetOutputConfigId(" + next + ") is not a valid id");
                return false;
            }
        }
        return true;
    }

    public void f(SessionConfig sessionConfig) {
        this.f5222d = sessionConfig;
    }

    public int setRepeating(RequestProcessor.Request request, RequestProcessor.Callback callback) {
        if (this.f5221c || !e(request)) {
            return -1;
        }
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.setTemplateType(request.getTemplateId());
        builder.setImplementationOptions(request.getParameters());
        builder.addCameraCaptureCallback(x1.a(new a(request, callback, true)));
        if (this.f5222d != null) {
            for (CameraCaptureCallback addCameraCaptureCallback : this.f5222d.getRepeatingCameraCaptureCallbacks()) {
                builder.addCameraCaptureCallback(addCameraCaptureCallback);
            }
            TagBundle tagBundle = this.f5222d.getRepeatingCaptureConfig().getTagBundle();
            for (String next : tagBundle.listKeys()) {
                builder.addTag(next, tagBundle.getTag(next));
            }
        }
        for (Integer intValue : request.getTargetOutputConfigIds()) {
            builder.addSurface(d(intValue.intValue()));
        }
        return this.f5219a.r(builder.build());
    }

    public void stopRepeating() {
        if (!this.f5221c) {
            this.f5219a.y();
        }
    }

    public int submit(RequestProcessor.Request request, RequestProcessor.Callback callback) {
        return submit((List<RequestProcessor.Request>) Arrays.asList(new RequestProcessor.Request[]{request}), callback);
    }

    public int submit(List<RequestProcessor.Request> list, RequestProcessor.Callback callback) {
        if (this.f5221c || !a(list)) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        boolean z11 = true;
        for (RequestProcessor.Request next : list) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(next.getTemplateId());
            builder.setImplementationOptions(next.getParameters());
            builder.addCameraCaptureCallback(x1.a(new a(next, callback, z11)));
            z11 = false;
            for (Integer intValue : next.getTargetOutputConfigIds()) {
                builder.addSurface(d(intValue.intValue()));
            }
            arrayList.add(builder.build());
        }
        return this.f5219a.p(arrayList);
    }
}
