package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class z {
    private static final BitSet AppsFlyer2dXConversionCallback;
    private static final Handler getLevel = new Handler(Looper.getMainLooper());
    private static volatile z init;
    public final Object AFInAppEventParameterName = new Object();
    public final Runnable AFInAppEventType;
    public final Runnable AFKeystoreWrapper;
    public final Executor AFLogger$LogLevel;
    public final Runnable AFVersionDeclaration;
    private long onAppOpenAttribution;
    /* access modifiers changed from: private */
    public final SensorManager onAppOpenAttributionNative;
    /* access modifiers changed from: private */
    public int onAttributionFailureNative;
    /* access modifiers changed from: private */
    public final Runnable onConversionDataSuccess;
    /* access modifiers changed from: private */
    public boolean onDeepLinkingNative;
    /* access modifiers changed from: private */
    public final Map<x, Map<String, Object>> onInstallConversionDataLoadedNative;
    /* access modifiers changed from: private */
    public final Map<x, x> onInstallConversionFailureNative;
    public final Handler valueOf;
    public boolean values;

    static {
        BitSet bitSet = new BitSet(6);
        AppsFlyer2dXConversionCallback = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    private z(SensorManager sensorManager, Handler handler) {
        BitSet bitSet = AppsFlyer2dXConversionCallback;
        this.onInstallConversionFailureNative = new HashMap(bitSet.size());
        this.onInstallConversionDataLoadedNative = new ConcurrentHashMap(bitSet.size());
        this.AFKeystoreWrapper = new Runnable() {
            public final void run() {
                synchronized (z.this.AFInAppEventParameterName) {
                    z zVar = z.this;
                    zVar.AFLogger$LogLevel.execute(new Runnable() {
                        public final void run() {
                            try {
                                for (Sensor next : z.this.onAppOpenAttributionNative.getSensorList(-1)) {
                                    if (z.values(next.getType())) {
                                        x xVar = new x(next, z.this.AFLogger$LogLevel);
                                        if (!z.this.onInstallConversionFailureNative.containsKey(xVar)) {
                                            z.this.onInstallConversionFailureNative.put(xVar, xVar);
                                        }
                                        z.this.onAppOpenAttributionNative.registerListener((SensorEventListener) z.this.onInstallConversionFailureNative.get(xVar), next, 0);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            boolean unused2 = z.this.onDeepLinkingNative = true;
                        }
                    });
                    z zVar2 = z.this;
                    zVar2.valueOf.postDelayed(zVar2.onConversionDataSuccess, 100);
                    z.this.values = true;
                }
            }
        };
        this.AFInAppEventType = new Runnable() {
            public final void run() {
                synchronized (z.this.AFInAppEventParameterName) {
                    z zVar = z.this;
                    zVar.AFLogger$LogLevel.execute(new Runnable() {
                        public final void run() {
                            try {
                                if (!z.this.onInstallConversionFailureNative.isEmpty()) {
                                    for (x xVar : z.this.onInstallConversionFailureNative.values()) {
                                        z.this.onAppOpenAttributionNative.unregisterListener(xVar);
                                        xVar.values(z.this.onInstallConversionDataLoadedNative, true);
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            int unused2 = z.this.onAttributionFailureNative = 0;
                            boolean unused3 = z.this.onDeepLinkingNative = false;
                        }
                    });
                }
            }
        };
        this.AFVersionDeclaration = new Runnable() {
            public final void run() {
                synchronized (z.this.AFInAppEventParameterName) {
                    z zVar = z.this;
                    if (zVar.values) {
                        zVar.valueOf.removeCallbacks(zVar.AFKeystoreWrapper);
                        z zVar2 = z.this;
                        zVar2.valueOf.removeCallbacks(zVar2.AFInAppEventType);
                        z zVar3 = z.this;
                        zVar3.AFLogger$LogLevel.execute(new Runnable() {
                            public final void run() {
                                try {
                                    if (!z.this.onInstallConversionFailureNative.isEmpty()) {
                                        for (x xVar : z.this.onInstallConversionFailureNative.values()) {
                                            z.this.onAppOpenAttributionNative.unregisterListener(xVar);
                                            xVar.values(z.this.onInstallConversionDataLoadedNative, true);
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                                int unused2 = z.this.onAttributionFailureNative = 0;
                                boolean unused3 = z.this.onDeepLinkingNative = false;
                            }
                        });
                        z.this.values = false;
                    }
                }
            }
        };
        this.onAttributionFailureNative = 1;
        this.onAppOpenAttribution = 0;
        this.onConversionDataSuccess = new Runnable() {
            public final void run() {
                synchronized (z.this.AFInAppEventParameterName) {
                    if (z.this.onAttributionFailureNative == 0) {
                        int unused = z.this.onAttributionFailureNative = 1;
                    }
                    z zVar = z.this;
                    zVar.valueOf.postDelayed(zVar.AFInAppEventType, ((long) zVar.onAttributionFailureNative) * 500);
                }
            }
        };
        this.AFLogger$LogLevel = Executors.newSingleThreadExecutor();
        this.onAppOpenAttributionNative = sensorManager;
        this.valueOf = handler;
    }

    public final void AFInAppEventType() {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.onAppOpenAttribution;
        if (j11 != 0) {
            this.onAttributionFailureNative++;
            if (j11 - currentTimeMillis < 500) {
                this.valueOf.removeCallbacks(this.AFInAppEventType);
                this.valueOf.post(this.AFKeystoreWrapper);
            }
        } else {
            this.valueOf.post(this.AFVersionDeclaration);
            this.valueOf.post(this.AFKeystoreWrapper);
        }
        this.onAppOpenAttribution = currentTimeMillis;
    }

    public static z AFKeystoreWrapper(Context context) {
        if (init != null) {
            return init;
        }
        return AFKeystoreWrapper((SensorManager) context.getApplicationContext().getSystemService("sensor"), getLevel);
    }

    /* access modifiers changed from: private */
    public static boolean values(int i11) {
        return i11 >= 0 && AppsFlyer2dXConversionCallback.get(i11);
    }

    public final List<Map<String, Object>> AFInAppEventParameterName() {
        synchronized (this.AFInAppEventParameterName) {
            if (!this.onInstallConversionFailureNative.isEmpty() && this.onDeepLinkingNative) {
                for (x values2 : this.onInstallConversionFailureNative.values()) {
                    values2.values(this.onInstallConversionDataLoadedNative, false);
                }
            }
            if (this.onInstallConversionDataLoadedNative.isEmpty()) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(Collections.emptyList());
                return copyOnWriteArrayList;
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
            return copyOnWriteArrayList2;
        }
    }

    public final List<Map<String, Object>> values() {
        for (x values2 : this.onInstallConversionFailureNative.values()) {
            values2.values(this.onInstallConversionDataLoadedNative, true);
        }
        Map<x, Map<String, Object>> map = this.onInstallConversionDataLoadedNative;
        if (map == null || map.isEmpty()) {
            return new CopyOnWriteArrayList(Collections.emptyList());
        }
        return new CopyOnWriteArrayList(this.onInstallConversionDataLoadedNative.values());
    }

    private static z AFKeystoreWrapper(SensorManager sensorManager, Handler handler) {
        if (init == null) {
            synchronized (z.class) {
                if (init == null) {
                    init = new z(sensorManager, handler);
                }
            }
        }
        return init;
    }
}
