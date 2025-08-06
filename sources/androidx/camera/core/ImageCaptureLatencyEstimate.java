package androidx.camera.core;

import java.util.Objects;

public class ImageCaptureLatencyEstimate {
    public static final long UNDEFINED_CAPTURE_LATENCY = -1;
    public static final ImageCaptureLatencyEstimate UNDEFINED_IMAGE_CAPTURE_LATENCY = new ImageCaptureLatencyEstimate(-1, -1);
    public static final long UNDEFINED_PROCESSING_LATENCY = -1;
    public final long captureLatencyMillis;
    public final long processingLatencyMillis;

    public ImageCaptureLatencyEstimate(long j11, long j12) {
        this.captureLatencyMillis = j11;
        this.processingLatencyMillis = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageCaptureLatencyEstimate)) {
            return false;
        }
        ImageCaptureLatencyEstimate imageCaptureLatencyEstimate = (ImageCaptureLatencyEstimate) obj;
        if (this.captureLatencyMillis == imageCaptureLatencyEstimate.captureLatencyMillis && this.processingLatencyMillis == imageCaptureLatencyEstimate.processingLatencyMillis) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.captureLatencyMillis), Long.valueOf(this.processingLatencyMillis)});
    }

    public String toString() {
        return "captureLatencyMillis=" + this.captureLatencyMillis + ", processingLatencyMillis=" + this.processingLatencyMillis;
    }
}
