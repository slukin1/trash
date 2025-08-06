package com.tencent.liteav.videoproducer.capture;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav::video")
public class CameraAbilityProvider {
    public static int getCamera2SupportLevel() {
        CameraManager cameraManager = (CameraManager) ContextUtils.getApplicationContext().getSystemService(OptionsBridge.CAMERA_KEY);
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length > 0) {
                return getSystemHardwareLevel(cameraManager, cameraIdList);
            }
            return -1;
        } catch (Throwable th2) {
            LiteavLog.e("CameraAbilityProvider", "getCamera2SupportLevel exception:".concat(String.valueOf(th2)));
            return -1;
        }
    }

    private static int getSystemHardwareLevel(CameraManager cameraManager, String[] strArr) throws Throwable {
        int i11 = -1;
        for (String cameraCharacteristics : strArr) {
            CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(cameraCharacteristics);
            Integer num = (Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING);
            if (num == null || num.intValue() == 0 || num.intValue() == 1) {
                Integer num2 = (Integer) cameraCharacteristics2.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (num2 == null) {
                    return -1;
                }
                i11 = num2.intValue();
            }
        }
        return i11;
    }
}
