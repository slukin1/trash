package com.tencent.liteav.videoproducer.capture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Process;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
public abstract class CameraControllerInterface {
    public static final int CAMERA_ERROR_DEVICE = 4;
    public static final int CAMERA_ERROR_DISABLED = 2;
    public static final int CAMERA_ERROR_OCCUPIED = 1;
    public static final int CAMERA_ERROR_SERVER_DIED = 3;
    public static final int CAMERA_ERROR_UNKNOWN = 0;
    private static final String TAG = "CameraControllerInterface";

    /* renamed from: com.tencent.liteav.videoproducer.capture.CameraControllerInterface$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22519a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.tencent.liteav.videoproducer.capture.CameraControllerInterface$a[] r0 = com.tencent.liteav.videoproducer.capture.CameraControllerInterface.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22519a = r0
                com.tencent.liteav.videoproducer.capture.CameraControllerInterface$a r1 = com.tencent.liteav.videoproducer.capture.CameraControllerInterface.a.CAMERA_2     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22519a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.videoproducer.capture.CameraControllerInterface$a r1 = com.tencent.liteav.videoproducer.capture.CameraControllerInterface.a.CAMERA_1     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoproducer.capture.CameraControllerInterface.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        MOCK(0),
        CAMERA_1(1),
        CAMERA_2(2);
        
        private final int mValue;

        private a(int i11) {
            this.mValue = i11;
        }

        public static a a(int i11) {
            for (a aVar : values()) {
                if (aVar.mValue == i11) {
                    return aVar;
                }
            }
            return CAMERA_1;
        }
    }

    public static CameraControllerInterface createCameraController(int i11, Handler handler) {
        CameraControllerInterface cameraControllerInterface;
        a a11 = a.a(i11);
        if (AnonymousClass1.f22519a[a11.ordinal()] != 1) {
            cameraControllerInterface = new com.tencent.liteav.videoproducer.capture.a.a();
        } else {
            handler.getClass();
            cameraControllerInterface = new com.tencent.liteav.videoproducer.capture.b.a(new a(handler));
        }
        LiteavLog.i(TAG, "createCameraController, CameraAPIType:" + a11 + ", return camera controller: " + cameraControllerInterface);
        return cameraControllerInterface;
    }

    public static boolean hasCameraPermission() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || LiteavSystemInfo.getSystemOSVersionInt() < 23 || applicationContext.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public abstract void enableCameraFpsCorrectionLogic(boolean z11);

    public abstract void enableTapToFocus(boolean z11);

    public abstract k getCameraSystemRotation();

    public abstract int getCameraSystemRotationValue();

    public abstract int getMaxZoom();

    public abstract Size getPreviewSize();

    public abstract boolean isCameraAutoFocusFaceModeSupported();

    public abstract boolean isCameraFocusPositionInPreviewSupported();

    public abstract boolean isCurrentPreviewSizeAspectRatioMatch(int i11, int i12, boolean z11);

    public abstract boolean isTorchSupported();

    public abstract boolean isZoomSupported();

    public abstract void setCameraRotationCorrectionValue(int i11);

    public abstract void setExposureCompensation(float f11);

    public abstract void setZoom(float f11);

    public abstract void startAutoFocusAtPosition(int i11, int i12);

    public abstract boolean startCapture(CameraCaptureParams cameraCaptureParams, SurfaceTexture surfaceTexture, CameraEventCallback cameraEventCallback);

    public abstract void stopCapture();

    public abstract void turnOnTorch(boolean z11);
}
