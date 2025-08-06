package com.hbg.lib.common.utils;

import android.view.View;

public class VibrateManager {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f67498a = false;

    public static void a(View view) {
        if (f67498a && view != null) {
            view.setHapticFeedbackEnabled(true);
            view.performHapticFeedback(0, 2);
        }
    }
}
