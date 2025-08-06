package com.jumio.commons.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.enums.ScreenAngle;

public class DeviceRotationManager {

    /* renamed from: a  reason: collision with root package name */
    public final Rotation f38980a;

    /* renamed from: b  reason: collision with root package name */
    public ScreenAngle f38981b;

    /* renamed from: c  reason: collision with root package name */
    public Context f38982c;

    /* renamed from: d  reason: collision with root package name */
    public final int f38983d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38984e;

    public DeviceRotationManager() {
        this.f38980a = Rotation.NONE;
        this.f38983d = 0;
        this.f38984e = false;
    }

    public static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) {
            return 2;
        }
        return 1;
    }

    public static boolean isTabletDevice(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || context.getResources().getConfiguration().smallestScreenWidthDp < 600) {
            return false;
        }
        return true;
    }

    public void destroy() {
        this.f38982c = null;
    }

    public ScreenAngle getAngle() {
        return this.f38981b;
    }

    public int getDisplayRotation() {
        Context context = this.f38982c;
        if (context == null) {
            return 0;
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public Rotation getRotation() {
        return this.f38980a;
    }

    public ScreenAngle getScreenOrientation() {
        ScreenAngle screenAngle = ScreenAngle.PORTRAIT;
        Context context = this.f38982c;
        if (context == null) {
            return screenAngle;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return (!this.f38984e || this.f38983d != 2) ? screenAngle : ScreenAngle.LANDSCAPE;
        }
        if (rotation == 1) {
            return (!this.f38984e || this.f38983d != 2) ? ScreenAngle.LANDSCAPE : ScreenAngle.INVERTED_PORTRAIT;
        }
        if (rotation == 2) {
            return (!this.f38984e || this.f38983d != 2) ? ScreenAngle.INVERTED_PORTRAIT : ScreenAngle.INVERTED_LANDSCAPE;
        }
        if (rotation != 3) {
            return screenAngle;
        }
        if (!this.f38984e || this.f38983d != 2) {
            return ScreenAngle.INVERTED_LANDSCAPE;
        }
        return screenAngle;
    }

    public boolean isAngle(ScreenAngle screenAngle) {
        return this.f38981b.equals(screenAngle);
    }

    public boolean isInverted() {
        ScreenAngle screenAngle = this.f38981b;
        return screenAngle == ScreenAngle.INVERTED_PORTRAIT || screenAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isLandscape() {
        ScreenAngle screenAngle = this.f38981b;
        return screenAngle == ScreenAngle.LANDSCAPE || screenAngle == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isPortrait() {
        ScreenAngle screenAngle = this.f38981b;
        return screenAngle == ScreenAngle.PORTRAIT || screenAngle == ScreenAngle.INVERTED_PORTRAIT;
    }

    public boolean isRotation(Rotation rotation) {
        return this.f38980a.equals(rotation);
    }

    public boolean isScreenLandscape() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.LANDSCAPE || screenOrientation == ScreenAngle.INVERTED_LANDSCAPE;
    }

    public boolean isScreenPortrait() {
        ScreenAngle screenOrientation = getScreenOrientation();
        return screenOrientation == ScreenAngle.PORTRAIT || screenOrientation == ScreenAngle.INVERTED_PORTRAIT;
    }

    public void setAngleFromScreen() {
        this.f38981b = getScreenOrientation();
    }

    public DeviceRotationManager(Context context, Rotation rotation) {
        this.f38982c = context;
        this.f38980a = rotation;
        this.f38984e = isTabletDevice(context);
        this.f38983d = a(context);
        this.f38981b = getScreenOrientation();
        setAngleFromScreen();
    }
}
