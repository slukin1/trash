package com.google.firebase.crashlytics.internal.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.Logger;

class BatteryState {
    public static final int VELOCITY_CHARGING = 2;
    public static final int VELOCITY_FULL = 3;
    public static final int VELOCITY_UNPLUGGED = 1;
    private final Float level;
    private final boolean powerConnected;

    private BatteryState(Float f11, boolean z11) {
        this.powerConnected = z11;
        this.level = f11;
    }

    public static BatteryState get(Context context) {
        Float f11 = null;
        boolean z11 = false;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z11 = isPowerConnected(registerReceiver);
                f11 = getLevel(registerReceiver);
            }
        } catch (IllegalStateException e11) {
            Logger.getLogger().e("An error occurred getting battery state.", e11);
        }
        return new BatteryState(f11, z11);
    }

    private static Float getLevel(Intent intent) {
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        Float f11;
        if (!this.powerConnected || (f11 = this.level) == null) {
            return 1;
        }
        return ((double) f11.floatValue()) < 0.99d ? 2 : 3;
    }

    public boolean isPowerConnected() {
        return this.powerConnected;
    }

    private static boolean isPowerConnected(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }
}
