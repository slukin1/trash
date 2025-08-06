package com.tencent.liteav.videobase.videobase;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
public class SystemDisplayInfo {
    private static final String TAG = "SystemDisplayInfo";

    private static Display getDefaultDisplayByWindowManager() {
        Context c11 = i.a().c();
        if (c11 == null) {
            c11 = ContextUtils.getApplicationContext();
        }
        if (c11 == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        try {
            return ((WindowManager) c11.getSystemService("window")).getDefaultDisplay();
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "error getting display from window service.", th2);
            return null;
        }
    }

    public static Display getDisplay() {
        Display displayByDisplayManager = getDisplayByDisplayManager();
        if (displayByDisplayManager != null) {
            return displayByDisplayManager;
        }
        return getDefaultDisplayByWindowManager();
    }

    private static Display getDisplayByDisplayManager() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 32) {
            return null;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        try {
            return ((DisplayManager) applicationContext.getSystemService("display")).getDisplay(0);
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "error getting display from display service.", th2);
            return null;
        }
    }

    public static k getDisplayRotation() {
        k displayRotationCorrection = getDisplayRotationCorrection();
        if (displayRotationCorrection != null) {
            return displayRotationCorrection;
        }
        try {
            Display display = getDisplay();
            if (display != null) {
                return surfaceRotationEnumToRotation(display.getRotation());
            }
        } catch (Exception e11) {
            LiteavLog.e(TAG, "error getting display rotation.", (Throwable) e11);
        }
        return k.NORMAL;
    }

    private static k getDisplayRotationCorrection() {
        int nativeGetDisplayRotationCorrection = nativeGetDisplayRotationCorrection();
        if (k.b(nativeGetDisplayRotationCorrection)) {
            return k.a(nativeGetDisplayRotationCorrection);
        }
        return null;
    }

    public static int getDisplayRotationDegree() {
        return getDisplayRotation().mValue;
    }

    public static Size getDisplaySize() {
        try {
            Display display = getDisplay();
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e11) {
            LiteavLog.e(TAG, "error getting display size.", (Throwable) e11);
        }
        return new Size(720, 1280);
    }

    private static native synchronized int nativeGetDisplayRotationCorrection();

    private static k surfaceRotationEnumToRotation(int i11) {
        if (i11 == 1) {
            return k.ROTATION_90;
        }
        if (i11 == 2) {
            return k.ROTATION_180;
        }
        if (i11 != 3) {
            return k.NORMAL;
        }
        return k.ROTATION_270;
    }
}
