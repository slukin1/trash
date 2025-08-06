package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceInfo {

    /* renamed from: a  reason: collision with root package name */
    private BuildInfo f49755a = new BuildInfo();

    /* renamed from: b  reason: collision with root package name */
    private ScreenInfo f49756b;

    public class BuildInfo {

        /* renamed from: b  reason: collision with root package name */
        private String f49758b = Build.BRAND;

        /* renamed from: c  reason: collision with root package name */
        private String f49759c = Build.VERSION.RELEASE;

        /* renamed from: d  reason: collision with root package name */
        private int f49760d = Build.VERSION.SDK_INT;

        /* renamed from: e  reason: collision with root package name */
        private String f49761e = Locale.getDefault().getLanguage();

        /* renamed from: f  reason: collision with root package name */
        private String f49762f = TimeZone.getDefault().getID();

        public BuildInfo() {
        }

        public String toString() {
            return "BuildInfo{brand='" + this.f49758b + '\'' + ", systemVersion='" + this.f49759c + '\'' + ", sdkVersion=" + this.f49760d + ", language='" + this.f49761e + '\'' + ", timezone='" + this.f49762f + '\'' + '}';
        }
    }

    public class ScreenInfo {

        /* renamed from: b  reason: collision with root package name */
        private int f49764b;

        /* renamed from: c  reason: collision with root package name */
        private int f49765c;

        public ScreenInfo(Context context) {
            this.f49764b = a(context);
            this.f49765c = b(context);
        }

        private int a(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        private int b(Context context) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }

        public String toString() {
            return "ScreenInfo{width=" + this.f49764b + ", height=" + this.f49765c + '}';
        }
    }

    public DeviceInfo(Context context) {
        this.f49756b = new ScreenInfo(context);
    }

    public String toString() {
        return "DeviceInfo{buildInfo=" + this.f49755a + ", screenInfo=" + this.f49756b + '}';
    }
}
