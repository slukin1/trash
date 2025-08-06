package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;

    public AutoValue_TakePictureRequest(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback, ImageCapture.OnImageSavedCallback onImageSavedCallback, ImageCapture.OutputFileOptions outputFileOptions2, Rect rect, Matrix matrix, int i11, int i12, int i13, List<CameraCaptureCallback> list) {
        Objects.requireNonNull(executor, "Null appExecutor");
        this.appExecutor = executor;
        this.inMemoryCallback = onImageCapturedCallback;
        this.onDiskCallback = onImageSavedCallback;
        this.outputFileOptions = outputFileOptions2;
        Objects.requireNonNull(rect, "Null cropRect");
        this.cropRect = rect;
        Objects.requireNonNull(matrix, "Null sensorToBufferTransform");
        this.sensorToBufferTransform = matrix;
        this.rotationDegrees = i11;
        this.jpegQuality = i12;
        this.captureMode = i13;
        Objects.requireNonNull(list, "Null sessionConfigCameraCaptureCallbacks");
        this.sessionConfigCameraCaptureCallbacks = list;
    }

    public boolean equals(Object obj) {
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback;
        ImageCapture.OnImageSavedCallback onImageSavedCallback;
        ImageCapture.OutputFileOptions outputFileOptions2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TakePictureRequest)) {
            return false;
        }
        TakePictureRequest takePictureRequest = (TakePictureRequest) obj;
        if (!this.appExecutor.equals(takePictureRequest.getAppExecutor()) || ((onImageCapturedCallback = this.inMemoryCallback) != null ? !onImageCapturedCallback.equals(takePictureRequest.getInMemoryCallback()) : takePictureRequest.getInMemoryCallback() != null) || ((onImageSavedCallback = this.onDiskCallback) != null ? !onImageSavedCallback.equals(takePictureRequest.getOnDiskCallback()) : takePictureRequest.getOnDiskCallback() != null) || ((outputFileOptions2 = this.outputFileOptions) != null ? !outputFileOptions2.equals(takePictureRequest.getOutputFileOptions()) : takePictureRequest.getOutputFileOptions() != null) || !this.cropRect.equals(takePictureRequest.getCropRect()) || !this.sensorToBufferTransform.equals(takePictureRequest.getSensorToBufferTransform()) || this.rotationDegrees != takePictureRequest.getRotationDegrees() || this.jpegQuality != takePictureRequest.getJpegQuality() || this.captureMode != takePictureRequest.getCaptureMode() || !this.sessionConfigCameraCaptureCallbacks.equals(takePictureRequest.getSessionConfigCameraCaptureCallbacks())) {
            return false;
        }
        return true;
    }

    public Executor getAppExecutor() {
        return this.appExecutor;
    }

    public int getCaptureMode() {
        return this.captureMode;
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    public int getJpegQuality() {
        return this.jpegQuality;
    }

    public ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    public List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public int hashCode() {
        int hashCode = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback = this.inMemoryCallback;
        int i11 = 0;
        int hashCode2 = (hashCode ^ (onImageCapturedCallback == null ? 0 : onImageCapturedCallback.hashCode())) * 1000003;
        ImageCapture.OnImageSavedCallback onImageSavedCallback = this.onDiskCallback;
        int hashCode3 = (hashCode2 ^ (onImageSavedCallback == null ? 0 : onImageSavedCallback.hashCode())) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions2 = this.outputFileOptions;
        if (outputFileOptions2 != null) {
            i11 = outputFileOptions2.hashCode();
        }
        return ((((((((((((hashCode3 ^ i11) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + "}";
    }
}
