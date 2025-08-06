package com.tencent.qcloud.tuikit.tuicallkit.extensions;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;

public class CallingScreenSensorFeature {
    private Context mContext;
    private boolean mEnableCloseScreenNearEar = false;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;

    public CallingScreenSensorFeature(Context context) {
        this.mContext = context;
    }

    public void enableScreenSensor(boolean z11) {
        this.mEnableCloseScreenNearEar = z11;
    }

    public void registerSensorEventListener() {
        if (this.mEnableCloseScreenNearEar && this.mSensorManager == null) {
            SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            this.mSensorManager = sensorManager;
            Sensor defaultSensor = sensorManager.getDefaultSensor(8);
            final PowerManager.WakeLock newWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(32, "TUICalling:TRTCAudioCallWakeLock");
            AnonymousClass1 r22 = new SensorEventListener() {
                public void onAccuracyChanged(Sensor sensor, int i11) {
                }

                public void onSensorChanged(SensorEvent sensorEvent) {
                    if (sensorEvent.sensor.getType() != 8) {
                        return;
                    }
                    if (((double) sensorEvent.values[0]) == 0.0d) {
                        if (!newWakeLock.isHeld()) {
                            newWakeLock.acquire();
                        }
                    } else if (newWakeLock.isHeld()) {
                        newWakeLock.setReferenceCounted(false);
                        newWakeLock.release();
                    }
                }
            };
            this.mSensorEventListener = r22;
            this.mSensorManager.registerListener(r22, defaultSensor, 0);
        }
    }

    public void unregisterSensorEventListener() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null && this.mSensorEventListener != null) {
            this.mSensorManager.unregisterListener(this.mSensorEventListener, sensorManager.getDefaultSensor(8));
            this.mSensorManager = null;
        }
    }
}
