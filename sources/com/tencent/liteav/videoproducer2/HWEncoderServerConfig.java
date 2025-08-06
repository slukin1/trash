package com.tencent.liteav.videoproducer2;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::video")
public class HWEncoderServerConfig {
    private Boolean hardwareEncoderBitrateModeCBRSupported;
    private int mHardwareEncodeType = 2;
    private boolean mHardwareEncoderHighProfileEnable = true;
    private boolean mHardwareEncoderHighProfileSupport = true;

    public static boolean isHWHevcEncodeAllowed() {
        return nativeIsHardwareHevcEncodeAllowed();
    }

    private static native boolean nativeIsHardwareHevcEncodeAllowed();

    public int getHardwareEncodeType() {
        return this.mHardwareEncodeType;
    }

    public boolean getHardwareEncoderHighProfileEnable() {
        return this.mHardwareEncoderHighProfileEnable;
    }

    public boolean getHardwareEncoderHighProfileSupport() {
        return this.mHardwareEncoderHighProfileSupport;
    }

    public boolean isHardwareEncoderAllowed() {
        return this.mHardwareEncodeType != 0;
    }

    public Boolean isHardwareEncoderBitrateModeCBRSupported() {
        return this.hardwareEncoderBitrateModeCBRSupported;
    }

    public boolean isHardwareEncoderHighProfileAllowed() {
        return this.mHardwareEncodeType == 2 && this.mHardwareEncoderHighProfileEnable && this.mHardwareEncoderHighProfileSupport;
    }

    public void setHardwareEncodeType(int i11) {
        this.mHardwareEncodeType = i11;
    }

    public void setHardwareEncoderBitrateModeCBRSupported(boolean z11) {
        this.hardwareEncoderBitrateModeCBRSupported = Boolean.valueOf(z11);
    }

    public void setHardwareEncoderHighProfileEnable(boolean z11) {
        this.mHardwareEncoderHighProfileEnable = z11;
    }

    public void setHardwareEncoderHighProfileSupport(boolean z11) {
        this.mHardwareEncoderHighProfileSupport = z11;
    }
}
