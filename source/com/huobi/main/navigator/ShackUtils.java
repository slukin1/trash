package com.huobi.main.navigator;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import bh.j;
import java.util.ArrayList;

public class ShackUtils implements SensorEventListener {

    /* renamed from: h  reason: collision with root package name */
    public static int f77747h = 500;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f77748b = null;

    /* renamed from: c  reason: collision with root package name */
    public long f77749c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f77750d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f77751e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f77752f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f77753g = 0.0f;

    public interface a {
        void j4(double d11);
    }

    public ShackUtils() {
        SensorManager sensorManager = (SensorManager) j.c().getSystemService("sensor");
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), 2);
        this.f77748b = new ArrayList<>();
    }

    public final void a(double d11) {
        Log.d("ShakeUtils", "startShake() called with: speed = [" + d11 + "]");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f77749c >= 1024) {
            this.f77749c = currentTimeMillis;
            for (int i11 = 0; i11 < this.f77748b.size(); i11++) {
                this.f77748b.get(i11).j4(d11);
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j11 = currentTimeMillis - this.f77750d;
            if (j11 >= 55) {
                float[] fArr = sensorEvent.values;
                if (fArr.length >= 3) {
                    this.f77750d = currentTimeMillis;
                    float f11 = fArr[0];
                    float f12 = fArr[1];
                    float f13 = fArr[2];
                    float f14 = f11 - this.f77751e;
                    float f15 = f12 - this.f77752f;
                    float f16 = f13 - this.f77753g;
                    this.f77751e = f11;
                    this.f77752f = f12;
                    this.f77753g = f13;
                    double sqrt = (Math.sqrt((double) (((f14 * f14) + (f15 * f15)) + (f16 * f16))) * 1000.0d) / ((double) j11);
                    if (sqrt >= ((double) f77747h)) {
                        a(sqrt);
                    }
                }
            }
        }
    }
}
