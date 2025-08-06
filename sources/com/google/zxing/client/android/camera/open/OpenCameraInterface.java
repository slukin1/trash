package com.google.zxing.client.android.camera.open;

import android.hardware.Camera;
import android.util.Log;

public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;
    private static final String TAG = "com.google.zxing.client.android.camera.open.OpenCameraInterface";

    private OpenCameraInterface() {
    }

    public static OpenCamera open(int i11) {
        Camera.CameraInfo cameraInfo;
        int i12;
        Camera camera;
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(TAG, "No cameras!");
            return null;
        }
        boolean z11 = i11 >= 0;
        if (!z11) {
            i12 = 0;
            while (true) {
                if (i12 >= numberOfCameras) {
                    cameraInfo = null;
                    break;
                }
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i12, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i12++;
            }
        } else {
            Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
            Camera.getCameraInfo(i11, cameraInfo2);
            cameraInfo = cameraInfo2;
            i12 = i11;
        }
        if (i12 < numberOfCameras) {
            Log.i(TAG, "Opening camera #" + i12);
            camera = Camera.open(i12);
        } else if (z11) {
            Log.w(TAG, "Requested camera does not exist: " + i11);
            camera = null;
        } else {
            Log.i(TAG, "No camera facing " + CameraFacing.BACK + "; returning camera #0");
            camera = Camera.open(0);
            cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
        }
        if (camera == null) {
            return null;
        }
        return new OpenCamera(i12, camera, CameraFacing.values()[cameraInfo.facing], cameraInfo.orientation);
    }
}
