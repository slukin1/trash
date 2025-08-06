package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;

public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    public static class CameraIdListIncorrectException extends Exception {
        public CameraIdListIncorrectException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    private CameraValidator() {
    }

    public static void validateCameras(Context context, CameraRepository cameraRepository, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer num;
        if (cameraSelector != null) {
            try {
                num = cameraSelector.getLensFacing();
                if (num == null) {
                    Logger.w(TAG, "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e11) {
                Logger.e(TAG, "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e11);
                return;
            }
        } else {
            num = null;
        }
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + num);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || num.intValue() == 1)) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
            }
            if (!packageManager.hasSystemFeature("android.hardware.camera.front")) {
                return;
            }
            if (cameraSelector == null || num.intValue() == 0) {
                CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
            }
        } catch (IllegalArgumentException e12) {
            Logger.e(TAG, "Camera LensFacing verification failed, existing cameras: " + cameraRepository.getCameras());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", e12);
        }
    }
}
