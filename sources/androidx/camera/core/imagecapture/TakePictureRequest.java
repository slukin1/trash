package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.h;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

@AutoValue
public abstract class TakePictureRequest {
    private int mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();

    public interface RetryControl {
        void retryRequest(TakePictureRequest takePictureRequest);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onError$0(ImageCaptureException imageCaptureException) {
        boolean z11 = true;
        boolean z12 = getInMemoryCallback() != null;
        if (getOnDiskCallback() == null) {
            z11 = false;
        }
        if (z12 && !z11) {
            ImageCapture.OnImageCapturedCallback inMemoryCallback = getInMemoryCallback();
            Objects.requireNonNull(inMemoryCallback);
            inMemoryCallback.onError(imageCaptureException);
        } else if (!z11 || z12) {
            throw new IllegalStateException("One and only one callback is allowed.");
        } else {
            ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
            Objects.requireNonNull(onDiskCallback);
            onDiskCallback.onError(imageCaptureException);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$1(ImageCapture.OutputFileResults outputFileResults) {
        ImageCapture.OnImageSavedCallback onDiskCallback = getOnDiskCallback();
        Objects.requireNonNull(onDiskCallback);
        Objects.requireNonNull(outputFileResults);
        onDiskCallback.onImageSaved(outputFileResults);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$2(ImageProxy imageProxy) {
        ImageCapture.OnImageCapturedCallback inMemoryCallback = getInMemoryCallback();
        Objects.requireNonNull(inMemoryCallback);
        Objects.requireNonNull(imageProxy);
        inMemoryCallback.onCaptureSuccess(imageProxy);
    }

    public static TakePictureRequest of(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions, Rect rect, Matrix matrix, int i11, int i12, int i13, List<CameraCaptureCallback> list) {
        boolean z11 = true;
        h.b((onImageSavedCallback == null) == (outputFileOptions == null), "onDiskCallback and outputFileOptions should be both null or both non-null.");
        boolean z12 = onImageSavedCallback == null;
        if (onImageCapturedCallback != null) {
            z11 = false;
        }
        h.b(z11 ^ z12, "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, rect, matrix, i11, i12, i13, list);
    }

    public boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int i11 = this.mRemainingRetires;
        if (i11 <= 0) {
            return false;
        }
        this.mRemainingRetires = i11 - 1;
        return true;
    }

    public abstract Executor getAppExecutor();

    public abstract int getCaptureMode();

    public abstract Rect getCropRect();

    public abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    public abstract int getJpegQuality();

    public abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    public int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    public void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    public void onError(ImageCaptureException imageCaptureException) {
        getAppExecutor().execute(new s(this, imageCaptureException));
    }

    public void onResult(ImageCapture.OutputFileResults outputFileResults) {
        getAppExecutor().execute(new r(this, outputFileResults));
    }

    public void onResult(ImageProxy imageProxy) {
        getAppExecutor().execute(new t(this, imageProxy));
    }
}
