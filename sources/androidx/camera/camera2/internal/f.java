package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.a;
import androidx.camera.core.impl.utils.ExifData;
import java.nio.BufferUnderflowException;

public class f implements CameraCaptureResult {

    /* renamed from: a  reason: collision with root package name */
    public final TagBundle f5103a;

    /* renamed from: b  reason: collision with root package name */
    public final CaptureResult f5104b;

    public f(TagBundle tagBundle, CaptureResult captureResult) {
        this.f5103a = tagBundle;
        this.f5104b = captureResult;
    }

    public CameraCaptureMetaData.AeState getAeState() {
        Integer num = (Integer) this.f5104b.get(CaptureResult.CONTROL_AE_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AeState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData.AeState.INACTIVE;
        }
        if (intValue != 1) {
            if (intValue == 2) {
                return CameraCaptureMetaData.AeState.CONVERGED;
            }
            if (intValue == 3) {
                return CameraCaptureMetaData.AeState.LOCKED;
            }
            if (intValue == 4) {
                return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
            }
            if (intValue != 5) {
                Logger.e("C2CameraCaptureResult", "Undefined ae state: " + num);
                return CameraCaptureMetaData.AeState.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AeState.SEARCHING;
    }

    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer num = (Integer) this.f5104b.get(CaptureResult.CONTROL_AF_MODE);
        if (num == null) {
            return CameraCaptureMetaData.AfMode.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1 || intValue == 2) {
                return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
            }
            if (intValue == 3 || intValue == 4) {
                return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
            }
            if (intValue != 5) {
                Logger.e("C2CameraCaptureResult", "Undefined af mode: " + num);
                return CameraCaptureMetaData.AfMode.UNKNOWN;
            }
        }
        return CameraCaptureMetaData.AfMode.OFF;
    }

    public CameraCaptureMetaData.AfState getAfState() {
        Integer num = (Integer) this.f5104b.get(CaptureResult.CONTROL_AF_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AfState.UNKNOWN;
        }
        switch (num.intValue()) {
            case 0:
                return CameraCaptureMetaData.AfState.INACTIVE;
            case 1:
            case 3:
                return CameraCaptureMetaData.AfState.SCANNING;
            case 2:
                return CameraCaptureMetaData.AfState.PASSIVE_FOCUSED;
            case 4:
                return CameraCaptureMetaData.AfState.LOCKED_FOCUSED;
            case 5:
                return CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
            case 6:
                return CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED;
            default:
                Logger.e("C2CameraCaptureResult", "Undefined af state: " + num);
                return CameraCaptureMetaData.AfState.UNKNOWN;
        }
    }

    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer num = (Integer) this.f5104b.get(CaptureResult.CONTROL_AWB_STATE);
        if (num == null) {
            return CameraCaptureMetaData.AwbState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0) {
            return CameraCaptureMetaData.AwbState.INACTIVE;
        }
        if (intValue == 1) {
            return CameraCaptureMetaData.AwbState.METERING;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData.AwbState.CONVERGED;
        }
        if (intValue == 3) {
            return CameraCaptureMetaData.AwbState.LOCKED;
        }
        Logger.e("C2CameraCaptureResult", "Undefined awb state: " + num);
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    public CaptureResult getCaptureResult() {
        return this.f5104b;
    }

    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer num = (Integer) this.f5104b.get(CaptureResult.FLASH_STATE);
        if (num == null) {
            return CameraCaptureMetaData.FlashState.UNKNOWN;
        }
        int intValue = num.intValue();
        if (intValue == 0 || intValue == 1) {
            return CameraCaptureMetaData.FlashState.NONE;
        }
        if (intValue == 2) {
            return CameraCaptureMetaData.FlashState.READY;
        }
        if (intValue == 3 || intValue == 4) {
            return CameraCaptureMetaData.FlashState.FIRED;
        }
        Logger.e("C2CameraCaptureResult", "Undefined flash state: " + num);
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    public TagBundle getTagBundle() {
        return this.f5103a;
    }

    public long getTimestamp() {
        Long l11 = (Long) this.f5104b.get(CaptureResult.SENSOR_TIMESTAMP);
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public void populateExifData(ExifData.Builder builder) {
        Integer num;
        a.b(this, builder);
        Rect rect = (Rect) this.f5104b.get(CaptureResult.SCALER_CROP_REGION);
        if (rect != null) {
            builder.setImageWidth(rect.width()).setImageHeight(rect.height());
        }
        try {
            Integer num2 = (Integer) this.f5104b.get(CaptureResult.JPEG_ORIENTATION);
            if (num2 != null) {
                builder.setOrientationDegrees(num2.intValue());
            }
        } catch (BufferUnderflowException unused) {
            Logger.w("C2CameraCaptureResult", "Failed to get JPEG orientation.");
        }
        Long l11 = (Long) this.f5104b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (l11 != null) {
            builder.setExposureTimeNanos(l11.longValue());
        }
        Float f11 = (Float) this.f5104b.get(CaptureResult.LENS_APERTURE);
        if (f11 != null) {
            builder.setLensFNumber(f11.floatValue());
        }
        Integer num3 = (Integer) this.f5104b.get(CaptureResult.SENSOR_SENSITIVITY);
        if (num3 != null) {
            if (Build.VERSION.SDK_INT >= 24 && (num = (Integer) this.f5104b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                num3 = Integer.valueOf(num3.intValue() * ((int) (((float) num.intValue()) / 100.0f)));
            }
            builder.setIso(num3.intValue());
        }
        Float f12 = (Float) this.f5104b.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (f12 != null) {
            builder.setFocalLength(f12.floatValue());
        }
        Integer num4 = (Integer) this.f5104b.get(CaptureResult.CONTROL_AWB_MODE);
        if (num4 != null) {
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (num4.intValue() == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            builder.setWhiteBalanceMode(whiteBalanceMode);
        }
    }

    public f(CaptureResult captureResult) {
        this(TagBundle.emptyBundle(), captureResult);
    }
}
