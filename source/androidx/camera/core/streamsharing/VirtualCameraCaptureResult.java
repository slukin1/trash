package androidx.camera.core.streamsharing;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.a;
import androidx.camera.core.impl.utils.ExifData;

public class VirtualCameraCaptureResult implements CameraCaptureResult {
    private static final long INVALID_TIMESTAMP = -1;
    private final CameraCaptureResult mBaseCameraCaptureResult;
    private final TagBundle mTagBundle;
    private final long mTimestamp;

    public VirtualCameraCaptureResult(TagBundle tagBundle, CameraCaptureResult cameraCaptureResult) {
        this(cameraCaptureResult, tagBundle, -1);
    }

    public CameraCaptureMetaData.AeState getAeState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getAeState();
        }
        return CameraCaptureMetaData.AeState.UNKNOWN;
    }

    public CameraCaptureMetaData.AfMode getAfMode() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getAfMode();
        }
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    public CameraCaptureMetaData.AfState getAfState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getAfState();
        }
        return CameraCaptureMetaData.AfState.UNKNOWN;
    }

    public CameraCaptureMetaData.AwbState getAwbState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getAwbState();
        }
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    public /* synthetic */ CaptureResult getCaptureResult() {
        return a.a(this);
    }

    public CameraCaptureMetaData.FlashState getFlashState() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getFlashState();
        }
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public long getTimestamp() {
        CameraCaptureResult cameraCaptureResult = this.mBaseCameraCaptureResult;
        if (cameraCaptureResult != null) {
            return cameraCaptureResult.getTimestamp();
        }
        long j11 = this.mTimestamp;
        if (j11 != -1) {
            return j11;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    public /* synthetic */ void populateExifData(ExifData.Builder builder) {
        a.b(this, builder);
    }

    public VirtualCameraCaptureResult(TagBundle tagBundle, long j11) {
        this((CameraCaptureResult) null, tagBundle, j11);
    }

    private VirtualCameraCaptureResult(CameraCaptureResult cameraCaptureResult, TagBundle tagBundle, long j11) {
        this.mBaseCameraCaptureResult = cameraCaptureResult;
        this.mTagBundle = tagBundle;
        this.mTimestamp = j11;
    }
}
