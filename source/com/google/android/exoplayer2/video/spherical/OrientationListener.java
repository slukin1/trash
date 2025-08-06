package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

final class OrientationListener implements SensorEventListener {
    private final float[] angles = new float[3];
    private final float[] deviceOrientationMatrix4x4 = new float[16];
    private final Display display;
    private final Listener[] listeners;
    private final float[] recenterMatrix4x4 = new float[16];
    private boolean recenterMatrixComputed;
    private final float[] tempMatrix4x4 = new float[16];

    public interface Listener {
        void onOrientationChange(float[] fArr, float f11);
    }

    public OrientationListener(Display display2, Listener... listenerArr) {
        this.display = display2;
        this.listeners = listenerArr;
    }

    private float extractRoll(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.tempMatrix4x4);
        SensorManager.getOrientation(this.tempMatrix4x4, this.angles);
        return this.angles[2];
    }

    private void notifyListeners(float[] fArr, float f11) {
        for (Listener onOrientationChange : this.listeners) {
            onOrientationChange.onOrientationChange(fArr, f11);
        }
    }

    private void recenter(float[] fArr) {
        if (!this.recenterMatrixComputed) {
            FrameRotationQueue.computeRecenterMatrix(this.recenterMatrix4x4, fArr);
            this.recenterMatrixComputed = true;
        }
        float[] fArr2 = this.tempMatrix4x4;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.tempMatrix4x4, 0, this.recenterMatrix4x4, 0);
    }

    private void rotateAroundZ(float[] fArr, int i11) {
        if (i11 != 0) {
            int i12 = 130;
            int i13 = 129;
            if (i11 == 1) {
                i12 = 2;
            } else if (i11 == 2) {
                i13 = 130;
                i12 = 129;
            } else if (i11 == 3) {
                i13 = 1;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.tempMatrix4x4;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.tempMatrix4x4, i12, i13, fArr);
        }
    }

    private static void rotateYtoSky(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.deviceOrientationMatrix4x4, sensorEvent.values);
        rotateAroundZ(this.deviceOrientationMatrix4x4, this.display.getRotation());
        float extractRoll = extractRoll(this.deviceOrientationMatrix4x4);
        rotateYtoSky(this.deviceOrientationMatrix4x4);
        recenter(this.deviceOrientationMatrix4x4);
        notifyListeners(this.deviceOrientationMatrix4x4, extractRoll);
    }
}
