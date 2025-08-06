package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
public class ServerVideoProducerConfig {
    private int camera2SupportMinApiLevel = Integer.MAX_VALUE;
    private int cameraRotationCorrection = 0;
    private k gsensorRotationCorrection;
    private int hardwareEncodeType = 2;
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private boolean hardwareEncoderHighProfileEnable = true;
    private boolean hardwareEncoderHighProfileSupport = true;
    private boolean mEnableCameraFpsCorrectionLogic = true;
    private final String mTAG = ("ServerVideoProducerConfig_" + hashCode());

    private k cameraCloudConfigEnumToRotation(int i11) {
        if (i11 == 1) {
            return k.NORMAL;
        }
        if (i11 == 2) {
            return k.ROTATION_90;
        }
        if (i11 == 3) {
            return k.ROTATION_180;
        }
        if (i11 != 4) {
            return null;
        }
        return k.ROTATION_270;
    }

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getCamera2SupportMinApiLevel() {
        return this.camera2SupportMinApiLevel;
    }

    public String getCameraRotationCorrectionInfo() {
        return "[CameraV1Front:" + getCameraV1FrontRotationCorrection() + ", CameraV1Back:" + getCameraV1BackRotationCorrection() + ", CameraV2Front:" + getCameraV2FrontRotationCorrection() + ", CameraV2Back:" + getCameraV2BackRotationCorrection() + "]";
    }

    public k getCameraV1BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 8) & 255);
    }

    public k getCameraV1FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation(this.cameraRotationCorrection & 255);
    }

    public k getCameraV2BackRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 24) & 255);
    }

    public k getCameraV2FrontRotationCorrection() {
        return cameraCloudConfigEnumToRotation((this.cameraRotationCorrection >> 16) & 255);
    }

    public k getGsensorRotationCorrection() {
        return this.gsensorRotationCorrection;
    }

    public boolean isCameraFpsCorrectionLogicEnabled() {
        return this.mEnableCameraFpsCorrectionLogic;
    }

    public boolean isHardwareEncoderAllowed() {
        return this.hardwareEncodeType != 0;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        return this.hardwareEncodeType == 2 && this.hardwareEncoderHighProfileEnable && this.hardwareEncoderHighProfileSupport;
    }

    public void setCamera2SupportMinApiLevel(int i11) {
        this.camera2SupportMinApiLevel = i11;
    }

    public void setCameraFpsCorrectionLogicEnabled(boolean z11) {
        this.mEnableCameraFpsCorrectionLogic = z11;
        LiteavLog.i(this.mTAG, "set camera fps correction logic enabled value is ".concat(String.valueOf(z11)));
    }

    public void setCameraRotationCorrection(int i11) {
        this.cameraRotationCorrection = i11;
        LiteavLog.i(this.mTAG, "set camera rotation correction raw value is %#x.", Integer.valueOf(i11));
    }

    public void setGSensorRotationCorrection(int i11) {
        if (i11 >= 0 && i11 <= 3) {
            this.gsensorRotationCorrection = k.a(i11 * 90);
        }
    }

    public void setHardwareEncodeType(int i11) {
        this.hardwareEncodeType = i11;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z11) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z11);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z11) {
        this.hardwareEncoderHighProfileEnable = z11;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z11) {
        this.hardwareEncoderHighProfileSupport = z11;
    }

    public String toString() {
        return "hardwareEncodeType: " + this.hardwareEncodeType + ", hardwareEncoderHighProfileEnable: " + this.hardwareEncoderHighProfileEnable + ", hardwareEncoderHighProfileSupport: " + this.hardwareEncoderHighProfileSupport + ", camera2SupportMinApiLevel: " + this.camera2SupportMinApiLevel + ", hardwareEncoderBitrateModeCBRSupported: " + this.hardwareEncoderBitrateModeCBRSupported + ", gsensorRotationCorrection: " + this.gsensorRotationCorrection + ", cameraRotationCorrection: " + getCameraRotationCorrectionInfo();
    }
}
