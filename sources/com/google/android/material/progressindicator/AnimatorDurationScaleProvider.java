package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;

public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    public static void setDefaultSystemAnimatorDurationScale(float f11) {
        defaultSystemAnimatorDurationScale = f11;
    }

    public float getSystemAnimatorDurationScale(ContentResolver contentResolver) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        }
        if (i11 == 16) {
            return Settings.System.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        }
        return defaultSystemAnimatorDurationScale;
    }
}
