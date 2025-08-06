package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

final class x implements SensorEventListener {
    public final long[] AFInAppEventParameterName = new long[2];
    public final float[][] AFInAppEventType = new float[2][];
    public double AFKeystoreWrapper;
    private final String AFLogger$LogLevel;
    private final Executor AFVersionDeclaration;
    private final String getLevel;
    private final int init;
    public long valueOf;
    private final int values;

    public x(Sensor sensor, Executor executor) {
        this.AFVersionDeclaration = executor;
        int type = sensor.getType();
        this.values = type;
        String name = sensor.getName();
        String str = "";
        name = name == null ? str : name;
        this.getLevel = name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.AFLogger$LogLevel = str;
        this.init = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
    }

    private boolean AFInAppEventParameterName(int i11, String str, String str2) {
        return this.values == i11 && this.getLevel.equals(str) && this.AFLogger$LogLevel.equals(str2);
    }

    private boolean AFInAppEventType() {
        return this.AFInAppEventType[0] != null;
    }

    private Map<String, Object> AFKeystoreWrapper() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.getLevel);
        concurrentHashMap.put("sV", this.AFLogger$LogLevel);
        float[] fArr = this.AFInAppEventType[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", valueOf(fArr));
        }
        float[] fArr2 = this.AFInAppEventType[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", valueOf(fArr2));
        }
        return concurrentHashMap;
    }

    private static List<Float> valueOf(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return AFInAppEventParameterName(xVar.values, xVar.getLevel, xVar.AFLogger$LogLevel);
    }

    public final int hashCode() {
        return this.init;
    }

    public final void onAccuracyChanged(Sensor sensor, int i11) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        final long j11 = sensorEvent.timestamp;
        final float[] fArr = sensorEvent.values;
        this.AFVersionDeclaration.execute(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                x xVar = x.this;
                float[][] fArr = xVar.AFInAppEventType;
                float[] fArr2 = fArr[0];
                if (fArr2 == null) {
                    float[] fArr3 = fArr;
                    fArr[0] = Arrays.copyOf(fArr3, fArr3.length);
                    x.this.AFInAppEventParameterName[0] = currentTimeMillis;
                    return;
                }
                float[] fArr4 = fArr[1];
                if (fArr4 == null) {
                    float[] fArr5 = fArr;
                    float[] copyOf = Arrays.copyOf(fArr5, fArr5.length);
                    x xVar2 = x.this;
                    xVar2.AFInAppEventType[1] = copyOf;
                    xVar2.AFInAppEventParameterName[1] = currentTimeMillis;
                    xVar2.AFKeystoreWrapper = x.AFInAppEventParameterName(fArr2, copyOf);
                    return;
                }
                long j11 = j11;
                if (50000000 <= j11 - xVar.valueOf) {
                    xVar.valueOf = j11;
                    if (Arrays.equals(fArr4, fArr)) {
                        x.this.AFInAppEventParameterName[1] = currentTimeMillis;
                        return;
                    }
                    double AFInAppEventParameterName2 = x.AFInAppEventParameterName(fArr2, fArr);
                    x xVar3 = x.this;
                    if (AFInAppEventParameterName2 > xVar3.AFKeystoreWrapper) {
                        float[][] fArr6 = xVar3.AFInAppEventType;
                        float[] fArr7 = fArr;
                        fArr6[1] = Arrays.copyOf(fArr7, fArr7.length);
                        x xVar4 = x.this;
                        xVar4.AFInAppEventParameterName[1] = currentTimeMillis;
                        xVar4.AFKeystoreWrapper = AFInAppEventParameterName2;
                    }
                }
            }
        });
    }

    public final void values(Map<x, Map<String, Object>> map, boolean z11) {
        if (AFInAppEventType()) {
            map.put(this, AFKeystoreWrapper());
            if (z11) {
                int length = this.AFInAppEventType.length;
                for (int i11 = 0; i11 < length; i11++) {
                    this.AFInAppEventType[i11] = null;
                }
                int length2 = this.AFInAppEventParameterName.length;
                for (int i12 = 0; i12 < length2; i12++) {
                    this.AFInAppEventParameterName[i12] = 0;
                }
                this.AFKeystoreWrapper = 0.0d;
                this.valueOf = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, AFKeystoreWrapper());
        }
    }

    public static /* synthetic */ double AFInAppEventParameterName(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d11 = 0.0d;
        for (int i11 = 0; i11 < min; i11++) {
            d11 += StrictMath.pow((double) (fArr[i11] - fArr2[i11]), 2.0d);
        }
        return Math.sqrt(d11);
    }
}
