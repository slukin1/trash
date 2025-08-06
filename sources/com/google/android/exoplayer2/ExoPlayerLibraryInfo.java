package com.google.android.exoplayer2;

import android.os.Build;
import java.util.HashSet;

public final class ExoPlayerLibraryInfo {
    public static final boolean ASSERTIONS_ENABLED = true;
    @Deprecated
    public static final String DEFAULT_USER_AGENT;
    public static final boolean GL_ASSERTIONS_ENABLED = false;
    public static final String TAG = "ExoPlayer";
    public static final boolean TRACE_ENABLED = true;
    public static final String VERSION = "2.14.1";
    public static final int VERSION_INT = 2014001;
    public static final String VERSION_SLASHY = "ExoPlayerLib/2.14.1";
    private static final HashSet<String> registeredModules = new HashSet<>();
    private static String registeredModulesString = "goog.exo.core";

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 57);
        sb2.append("ExoPlayerLib/2.14.1 (Linux; Android ");
        sb2.append(str);
        sb2.append(") ");
        sb2.append(VERSION_SLASHY);
        DEFAULT_USER_AGENT = sb2.toString();
    }

    private ExoPlayerLibraryInfo() {
    }

    public static synchronized void registerModule(String str) {
        synchronized (ExoPlayerLibraryInfo.class) {
            if (registeredModules.add(str)) {
                String str2 = registeredModulesString;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb2.append(str2);
                sb2.append(", ");
                sb2.append(str);
                registeredModulesString = sb2.toString();
            }
        }
    }

    public static synchronized String registeredModules() {
        String str;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = registeredModulesString;
        }
        return str;
    }
}
