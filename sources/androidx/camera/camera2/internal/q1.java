package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.c;

public class q1 extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> f5277a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public a f5278b = null;

    public interface a {
        void a(CameraCaptureSession cameraCaptureSession, int i11, boolean z11);
    }

    public void a(CaptureRequest captureRequest, List<CameraCaptureSession.CaptureCallback> list) {
        List list2 = this.f5277a.get(captureRequest);
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size());
            arrayList.addAll(list);
            arrayList.addAll(list2);
            this.f5277a.put(captureRequest, arrayList);
            return;
        }
        this.f5277a.put(captureRequest, list);
    }

    public final List<CameraCaptureSession.CaptureCallback> b(CaptureRequest captureRequest) {
        List<CameraCaptureSession.CaptureCallback> list = this.f5277a.get(captureRequest);
        return list != null ? list : Collections.emptyList();
    }

    public void c(a aVar) {
        this.f5278b = aVar;
    }

    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j11) {
        for (CameraCaptureSession.CaptureCallback a11 : b(captureRequest)) {
            c.a(a11, cameraCaptureSession, captureRequest, surface, j11);
        }
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        for (CameraCaptureSession.CaptureCallback onCaptureCompleted : b(captureRequest)) {
            onCaptureCompleted.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        for (CameraCaptureSession.CaptureCallback onCaptureFailed : b(captureRequest)) {
            onCaptureFailed.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        for (CameraCaptureSession.CaptureCallback onCaptureProgressed : b(captureRequest)) {
            onCaptureProgressed.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
    }

    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i11) {
        for (List<CameraCaptureSession.CaptureCallback> it2 : this.f5277a.values()) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceAborted : it2) {
                onCaptureSequenceAborted.onCaptureSequenceAborted(cameraCaptureSession, i11);
            }
        }
        a aVar = this.f5278b;
        if (aVar != null) {
            aVar.a(cameraCaptureSession, i11, true);
        }
    }

    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i11, long j11) {
        for (List<CameraCaptureSession.CaptureCallback> it2 : this.f5277a.values()) {
            for (CameraCaptureSession.CaptureCallback onCaptureSequenceCompleted : it2) {
                onCaptureSequenceCompleted.onCaptureSequenceCompleted(cameraCaptureSession, i11, j11);
            }
        }
        a aVar = this.f5278b;
        if (aVar != null) {
            aVar.a(cameraCaptureSession, i11, false);
        }
    }

    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
        for (CameraCaptureSession.CaptureCallback onCaptureStarted : b(captureRequest)) {
            onCaptureStarted.onCaptureStarted(cameraCaptureSession, captureRequest, j11, j12);
        }
    }
}
