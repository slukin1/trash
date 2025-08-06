package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0];
            double d11 = (double) (f11 / 9.80665f);
            double d12 = (double) (fArr[1] / 9.80665f);
            double d13 = (double) (fArr[2] / 9.80665f);
            if (Math.sqrt((d11 * d11) + (d12 * d12) + (d13 * d13)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }
}
