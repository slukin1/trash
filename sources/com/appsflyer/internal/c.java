package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;

final class c {
    private IntentFilter AFInAppEventParameterName = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: com.appsflyer.internal.c$c  reason: collision with other inner class name */
    public static final class C0073c {
        public static final c AFKeystoreWrapper = new c();
    }

    public static final class e {
        public final String AFKeystoreWrapper;
        public final float values;

        public e(float f11, String str) {
            this.values = f11;
            this.AFKeystoreWrapper = str;
        }
    }

    public final e values(Context context) {
        String str = null;
        float f11 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, this.AFInAppEventParameterName);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra("status", -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    str = intExtra != 1 ? intExtra != 2 ? intExtra != 4 ? "other" : "wireless" : "usb" : "ac";
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f11 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable unused) {
        }
        return new e(f11, str);
    }
}
