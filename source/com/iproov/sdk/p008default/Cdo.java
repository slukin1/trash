package com.iproov.sdk.p008default;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* renamed from: com.iproov.sdk.default.do  reason: invalid class name and invalid package */
public class Cdo implements SensorEventListener {

    /* renamed from: do  reason: not valid java name */
    private final SensorManager f452do;

    /* renamed from: for  reason: not valid java name */
    private float f453for = -1.0f;

    /* renamed from: if  reason: not valid java name */
    private final Sensor f454if;

    public Cdo(Context context) throws Cif {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f452do = sensorManager;
        if (sensorManager != null) {
            this.f454if = sensorManager.getDefaultSensor(5);
            return;
        }
        throw new Cif();
    }

    /* renamed from: do  reason: not valid java name */
    public void m524do() {
        this.f452do.unregisterListener(this, this.f454if);
    }

    /* renamed from: for  reason: not valid java name */
    public void m525for() {
        this.f452do.registerListener(this, this.f454if, 3);
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized float m526if() {
        return this.f453for;
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public synchronized void onSensorChanged(SensorEvent sensorEvent) {
        this.f453for = sensorEvent.values[0];
    }
}
