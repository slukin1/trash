package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.camera.open.CameraFacing;
import com.google.zxing.client.android.camera.open.OpenCamera;

final class CameraConfigurationManager {
    private static final String TAG = "CameraConfiguration";
    private Point bestPreviewSize;
    private Point cameraResolution;
    private final Context context;
    private int cwNeededRotation;
    private int cwRotationFromDisplayToCamera;
    private Point previewSizeOnScreen;
    private Point screenResolution;

    public CameraConfigurationManager(Context context2) {
        this.context = context2;
    }

    private void doSetTorch(Camera.Parameters parameters, boolean z11, boolean z12) {
        CameraConfigurationUtils.setTorch(parameters, z11);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        if (!z12 && !defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_EXPOSURE, true)) {
            CameraConfigurationUtils.setBestExposure(parameters, z11);
        }
    }

    private void initializeTorch(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z11) {
        doSetTorch(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z11);
    }

    public Point getBestPreviewSize() {
        return this.bestPreviewSize;
    }

    public int getCWNeededRotation() {
        return this.cwNeededRotation;
    }

    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    public Point getPreviewSizeOnScreen() {
        return this.previewSizeOnScreen;
    }

    public Point getScreenResolution() {
        return this.screenResolution;
    }

    public boolean getTorchState(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        if (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    public void initFromCameraParameters(OpenCamera openCamera) {
        int i11;
        Camera.Parameters parameters = openCamera.getCamera().getParameters();
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        boolean z11 = false;
        if (rotation == 0) {
            i11 = 0;
        } else if (rotation == 1) {
            i11 = 90;
        } else if (rotation == 2) {
            i11 = 180;
        } else if (rotation == 3) {
            i11 = 270;
        } else if (rotation % 90 == 0) {
            i11 = (rotation + 360) % 360;
        } else {
            throw new IllegalArgumentException("Bad rotation: " + rotation);
        }
        Log.i(TAG, "Display at: " + i11);
        int orientation = openCamera.getOrientation();
        Log.i(TAG, "Camera at: " + orientation);
        CameraFacing facing = openCamera.getFacing();
        CameraFacing cameraFacing = CameraFacing.FRONT;
        if (facing == cameraFacing) {
            orientation = (360 - orientation) % 360;
            Log.i(TAG, "Front camera overriden to: " + orientation);
        }
        this.cwRotationFromDisplayToCamera = ((orientation + 360) - i11) % 360;
        Log.i(TAG, "Final display orientation: " + this.cwRotationFromDisplayToCamera);
        if (openCamera.getFacing() == cameraFacing) {
            Log.i(TAG, "Compensating rotation for front camera");
            this.cwNeededRotation = (360 - this.cwRotationFromDisplayToCamera) % 360;
        } else {
            this.cwNeededRotation = this.cwRotationFromDisplayToCamera;
        }
        Log.i(TAG, "Clockwise rotation from display to camera: " + this.cwNeededRotation);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.screenResolution = point;
        Log.i(TAG, "Screen resolution in current orientation: " + this.screenResolution);
        this.cameraResolution = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.screenResolution);
        Log.i(TAG, "Camera resolution: " + this.cameraResolution);
        this.bestPreviewSize = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.screenResolution);
        Log.i(TAG, "Best available preview size: " + this.bestPreviewSize);
        Point point2 = this.screenResolution;
        boolean z12 = point2.x < point2.y;
        Point point3 = this.bestPreviewSize;
        if (point3.x < point3.y) {
            z11 = true;
        }
        if (z12 == z11) {
            this.previewSizeOnScreen = point3;
        } else {
            Point point4 = this.bestPreviewSize;
            this.previewSizeOnScreen = new Point(point4.y, point4.x);
        }
        Log.i(TAG, "Preview size on screen: " + this.previewSizeOnScreen);
    }

    public void setDesiredCameraParameters(OpenCamera openCamera, boolean z11) {
        Camera camera = openCamera.getCamera();
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(TAG, "Initial camera parameters: " + parameters.flatten());
        if (z11) {
            Log.w(TAG, "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        initializeTorch(parameters, defaultSharedPreferences, z11);
        CameraConfigurationUtils.setFocus(parameters, defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_AUTO_FOCUS, true), defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_CONTINUOUS_FOCUS, true), z11);
        if (!z11) {
            if (defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_INVERT_SCAN, false)) {
                CameraConfigurationUtils.setInvertColor(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_BARCODE_SCENE_MODE, true)) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_METERING, true)) {
                CameraConfigurationUtils.setVideoStabilization(parameters);
                CameraConfigurationUtils.setFocusArea(parameters);
                CameraConfigurationUtils.setMetering(parameters);
            }
        }
        Point point = this.bestPreviewSize;
        parameters.setPreviewSize(point.x, point.y);
        camera.setParameters(parameters);
        camera.setDisplayOrientation(this.cwRotationFromDisplayToCamera);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.bestPreviewSize;
            if (point2.x != previewSize.width || point2.y != previewSize.height) {
                Log.w(TAG, "Camera said it supported preview size " + this.bestPreviewSize.x + 'x' + this.bestPreviewSize.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
                Point point3 = this.bestPreviewSize;
                point3.x = previewSize.width;
                point3.y = previewSize.height;
            }
        }
    }

    public void setTorch(Camera camera, boolean z11) {
        Camera.Parameters parameters = camera.getParameters();
        doSetTorch(parameters, z11, false);
        camera.setParameters(parameters);
    }
}
