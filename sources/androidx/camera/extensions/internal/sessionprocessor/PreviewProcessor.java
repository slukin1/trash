package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.impl.PreviewImageProcessorImpl;
import androidx.camera.extensions.impl.ProcessResultImpl;
import androidx.camera.extensions.internal.ExtensionVersion;
import java.util.List;
import u.b;
import u.c;

class PreviewProcessor {
    private static final String TAG = "PreviewProcessor";
    public final a mCaptureResultImageMatcher = new a();
    public boolean mIsClosed = false;
    public final Object mLock = new Object();
    public final PreviewImageProcessorImpl mPreviewImageProcessor;

    public interface OnCaptureResultCallback {
        void onCaptureResult(long j11, List<Pair<CaptureResult.Key, Object>> list);
    }

    public PreviewProcessor(PreviewImageProcessorImpl previewImageProcessorImpl, Surface surface, Size size) {
        this.mPreviewImageProcessor = previewImageProcessorImpl;
        previewImageProcessorImpl.onResolutionUpdate(size);
        previewImageProcessorImpl.onOutputSurface(surface, 1);
        previewImageProcessorImpl.onImageFormatUpdate(35);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(final OnCaptureResultCallback onCaptureResultCallback, b bVar, TotalCaptureResult totalCaptureResult, int i11) {
        synchronized (this.mLock) {
            if (this.mIsClosed) {
                bVar.a();
                Logger.d(TAG, "Ignore image in closed state");
                return;
            }
            c cVar = c.f16569e;
            if (!b.c(cVar) || !ExtensionVersion.d(cVar)) {
                this.mPreviewImageProcessor.process(bVar.get(), totalCaptureResult);
            } else {
                this.mPreviewImageProcessor.process(bVar.get(), totalCaptureResult, new ProcessResultImpl() {
                    public void onCaptureCompleted(long j11, List<Pair<CaptureResult.Key, Object>> list) {
                        onCaptureResultCallback.onCaptureResult(j11, list);
                    }

                    public void onCaptureProcessProgressed(int i11) {
                    }
                }, CameraXExecutors.ioExecutor());
            }
            bVar.a();
        }
    }

    public void close() {
        synchronized (this.mLock) {
            this.mIsClosed = true;
            this.mCaptureResultImageMatcher.c();
            this.mCaptureResultImageMatcher.d();
        }
    }

    public void notifyCaptureResult(TotalCaptureResult totalCaptureResult) {
        this.mCaptureResultImageMatcher.a(totalCaptureResult);
    }

    public void notifyImage(b bVar) {
        this.mCaptureResultImageMatcher.f(bVar);
    }

    public void start(OnCaptureResultCallback onCaptureResultCallback) {
        this.mCaptureResultImageMatcher.j(new c(this, onCaptureResultCallback));
    }
}
