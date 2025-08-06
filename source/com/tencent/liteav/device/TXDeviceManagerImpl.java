package com.tencent.liteav.device;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.device.TXDeviceManager;

@JNINamespace("liteav::manager")
public class TXDeviceManagerImpl implements TXDeviceManager {
    private long mNativeDeviceMgr = 0;

    public static class CameraCaptureParam {
        private TXDeviceManager.TXCameraCaptureParam mParams;

        public CameraCaptureParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
            this.mParams = tXCameraCaptureParam;
        }

        public int getHeight() {
            return this.mParams.height;
        }

        public int getMode() {
            return TXDeviceManagerImpl.cameraCaptureModeAsInt(this.mParams.mode);
        }

        public int getWidth() {
            return this.mParams.width;
        }
    }

    public TXDeviceManagerImpl(long j11) {
        this.mNativeDeviceMgr = j11;
    }

    public static int audioRouteAsInt(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        if (tXAudioRoute != TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone && tXAudioRoute == TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece) {
            return 1;
        }
        return 0;
    }

    public static TXDeviceManager.TXAudioRoute audioRouteFromInt(int i11) {
        if (i11 == 0) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
        }
        if (i11 == 1) {
            return TXDeviceManager.TXAudioRoute.TXAudioRouteEarpiece;
        }
        return TXDeviceManager.TXAudioRoute.TXAudioRouteSpeakerphone;
    }

    public static int cameraCaptureModeAsInt(TXDeviceManager.TXCameraCaptureMode tXCameraCaptureMode) {
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto) {
            return 0;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance) {
            return 1;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality) {
            return 2;
        }
        if (tXCameraCaptureMode == TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual) {
            return 3;
        }
        return 0;
    }

    public static TXDeviceManager.TXCameraCaptureMode cameraCaptureModeFromInt(int i11) {
        if (i11 == 0) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
        }
        if (i11 == 1) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyPerformance;
        }
        if (i11 == 2) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyHighQuality;
        }
        if (i11 == 3) {
            return TXDeviceManager.TXCameraCaptureMode.TXCameraCaptureManual;
        }
        return TXDeviceManager.TXCameraCaptureMode.TXCameraResolutionStrategyAuto;
    }

    private static native void nativeDestroy(long j11);

    private static native int nativeEnableCameraAutoFocus(long j11, boolean z11);

    private static native boolean nativeEnableCameraTorch(long j11, boolean z11);

    private static native float nativeGetCameraZoomMaxRatio(long j11);

    private static native boolean nativeIsAutoFocusEnabled(long j11);

    private static native boolean nativeIsCameraAutoFocusFaceModeSupported(long j11);

    private static native boolean nativeIsCameraFocusPositionInPreviewSupported(long j11);

    private static native boolean nativeIsCameraTorchSupported(long j11);

    private static native boolean nativeIsCameraZoomSupported(long j11);

    private static native boolean nativeIsFrontCamera(long j11);

    private static native boolean nativeIsLowLatencyEarMonitorSupported(long j11);

    private static native int nativeSetAudioRoute(long j11, int i11);

    private static native void nativeSetCameraCapturerParam(long j11, CameraCaptureParam cameraCaptureParam);

    private static native int nativeSetCameraFocusPosition(long j11, int i11, int i12);

    private static native int nativeSetCameraZoomRatio(long j11, float f11);

    private static native int nativeSetExposureCompensation(long j11, float f11);

    private static native int nativeSetSystemVolumeType(long j11, int i11);

    private static native int nativeSwitchCamera(long j11, boolean z11);

    public static int systemVolumeTypeAsInt(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto) {
            return 0;
        }
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia) {
            return 1;
        }
        if (tXSystemVolumeType == TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP) {
            return 2;
        }
        return 0;
    }

    public static TXDeviceManager.TXSystemVolumeType systemVolumeTypefromInt(int i11) {
        if (i11 == 0) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
        }
        if (i11 == 1) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia;
        }
        if (i11 == 2) {
            return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeVOIP;
        }
        return TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeAuto;
    }

    public int enableCameraAutoFocus(boolean z11) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeEnableCameraAutoFocus(j11, z11);
        }
        return 0;
    }

    public boolean enableCameraTorch(boolean z11) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeEnableCameraTorch(j11, z11);
        }
        return false;
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeDeviceMgr = 0;
        }
    }

    public float getCameraZoomMaxRatio() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeGetCameraZoomMaxRatio(j11);
        }
        return 0.0f;
    }

    public boolean isAutoFocusEnabled() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeIsAutoFocusEnabled(j11);
        }
        return false;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 == 0) {
            return false;
        }
        return nativeIsCameraAutoFocusFaceModeSupported(j11);
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 == 0) {
            return false;
        }
        return nativeIsCameraFocusPositionInPreviewSupported(j11);
    }

    public boolean isCameraTorchSupported() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 == 0) {
            return false;
        }
        return nativeIsCameraTorchSupported(j11);
    }

    public boolean isCameraZoomSupported() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeIsCameraZoomSupported(j11);
        }
        return false;
    }

    public boolean isFrontCamera() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeIsFrontCamera(j11);
        }
        return false;
    }

    public boolean isLowLatencyEarMonitorSupported() {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeIsLowLatencyEarMonitorSupported(j11);
        }
        return false;
    }

    public int setAudioRoute(TXDeviceManager.TXAudioRoute tXAudioRoute) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSetAudioRoute(j11, audioRouteAsInt(tXAudioRoute));
        }
        return 0;
    }

    public void setCameraCapturerParam(TXDeviceManager.TXCameraCaptureParam tXCameraCaptureParam) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            nativeSetCameraCapturerParam(j11, new CameraCaptureParam(tXCameraCaptureParam));
        }
    }

    public int setCameraFocusPosition(int i11, int i12) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSetCameraFocusPosition(j11, i11, i12);
        }
        return 0;
    }

    public int setCameraZoomRatio(float f11) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSetCameraZoomRatio(j11, f11);
        }
        return 0;
    }

    public int setExposureCompensation(float f11) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSetExposureCompensation(j11, f11);
        }
        return 0;
    }

    public int setSystemVolumeType(TXDeviceManager.TXSystemVolumeType tXSystemVolumeType) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSetSystemVolumeType(j11, systemVolumeTypeAsInt(tXSystemVolumeType));
        }
        return 0;
    }

    public int switchCamera(boolean z11) {
        long j11 = this.mNativeDeviceMgr;
        if (j11 != 0) {
            return nativeSwitchCamera(j11, z11);
        }
        return 0;
    }
}
