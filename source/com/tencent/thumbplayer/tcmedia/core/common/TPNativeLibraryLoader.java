package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

public class TPNativeLibraryLoader {
    private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.32.0.338.min";
    private static final String MAIN_PLAYER_CORE_VERSION = "2.32.0";
    private static boolean mIsLibLoaded = false;
    private static Object mIsLibLoadedLock = new Object();
    private static final boolean mIsNeedLoadThirdPartiesAndFFmpeg = true;
    private static final String mLibIjkPrefix = "ijkhlscache-master";
    private static ITPNativeLibraryExternalLoader mLibLoader = null;
    private static final boolean mLibNameHasArchSuffix = false;
    private static final String mLibPlayerCorePrefix = "tpcore-master";
    private static final String mLibThirdPartiesPrefix = "tpthirdparties-master";
    private static final int mPlayerCoreSupportMinAndroidAPILevel = 14;

    private static native String _getPlayerCoreVersion();

    public static String getLibVersion() {
        return getPlayerCoreVersion();
    }

    public static String getPlayerCoreVersion() {
        try {
            return _getPlayerCoreVersion();
        } catch (Throwable unused) {
            TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.32.0.338.min");
            return DEFAULT_LIB_PLAYER_CORE_VERSION;
        }
    }

    public static boolean isLibLoaded() {
        return mIsLibLoaded;
    }

    public static boolean isLibLoadedAndTryToLoad() {
        boolean z11;
        try {
            loadLibIfNeeded((Context) null);
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "TPNativeLibraryLoader isLibLoaded error:" + th2.getMessage());
        }
        synchronized (mIsLibLoadedLock) {
            z11 = mIsLibLoaded;
        }
        return z11;
    }

    private static boolean isMatchJavaAndPlayerCore(String str, String str2) {
        TPNativeLog.printLog(2, "javaVersion:" + str + ", coreVersion:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split.length < 3 || split2.length < 3) {
            return false;
        }
        for (int i11 = 0; i11 < 3; i11++) {
            if (!split[i11].matches(split2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static boolean loadLib(Context context) {
        String concat;
        TPNativeLog.printLog(2, "loadLib cpu arch:" + TPSystemInfo.getCpuArchitecture());
        int i11 = 3;
        boolean z11 = false;
        if (TPSystemInfo.getApiLevel() < 14) {
            concat = "so load failed, current api level " + TPSystemInfo.getApiLevel() + " is less than 14";
        } else {
            if (TPSystemInfo.getCpuArchitecture() != 3) {
                i11 = 4;
                if (!(TPSystemInfo.getCpuArchitecture() == 4 || TPSystemInfo.getCpuArchitecture() == 0)) {
                    String concat2 = mLibThirdPartiesPrefix.concat("");
                    ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader = mLibLoader;
                    if (!(iTPNativeLibraryExternalLoader != null ? iTPNativeLibraryExternalLoader.loadLib(concat2, DEFAULT_LIB_PLAYER_CORE_VERSION) : loadLibDefault(concat2, context))) {
                        concat = "Failed to load ".concat(String.valueOf(concat2));
                    } else {
                        String concat3 = mLibPlayerCorePrefix.concat("");
                        ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader2 = mLibLoader;
                        z11 = iTPNativeLibraryExternalLoader2 != null ? iTPNativeLibraryExternalLoader2.loadLib(concat3, DEFAULT_LIB_PLAYER_CORE_VERSION) : loadLibDefault(concat3, context);
                        if (z11) {
                            String playerCoreVersion = getPlayerCoreVersion();
                            boolean isMatchJavaAndPlayerCore = isMatchJavaAndPlayerCore(MAIN_PLAYER_CORE_VERSION, playerCoreVersion);
                            if (!isMatchJavaAndPlayerCore) {
                                TPNativeLog.printLog(4, "nativePlayerCoreVer(" + playerCoreVersion + ") doesn't match javaPlayerCoreVer:(2.32.0)");
                            }
                            z11 = isMatchJavaAndPlayerCore;
                        }
                        String concat4 = mLibIjkPrefix.concat("");
                        ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader3 = mLibLoader;
                        if (iTPNativeLibraryExternalLoader3 != null) {
                            iTPNativeLibraryExternalLoader3.loadLib(concat4, DEFAULT_LIB_PLAYER_CORE_VERSION);
                        } else {
                            loadLibDefault(concat4, context);
                        }
                        if (z11) {
                            TPNativeLog.printLog(2, "Native libs loaded successfully");
                        } else {
                            TPNativeLog.printLog(4, "Failed to load native libs");
                        }
                    }
                }
            }
            return z11;
        }
        TPNativeLog.printLog(i11, concat);
        return false;
    }

    private static boolean loadLibDefault(String str, Context context) {
        boolean z11 = false;
        try {
            TPNativeLog.printLog(2, "loadLibDefault loading ".concat(String.valueOf(str)));
            System.loadLibrary(str);
            z11 = true;
            TPNativeLog.printLog(2, "loadLibDefault " + str + " loaded successfully");
        } catch (Throwable th2) {
            TPNativeLog.printLog(4, "loadLibDefault failed to load " + str + Constants.ACCEPT_TIME_SEPARATOR_SP + th2.getMessage());
        }
        if (!z11 && context != null && TPSystemInfo.getCpuArchitecture() >= 6) {
            try {
                TPNativeLog.printLog(2, "loadLibDefault try to load " + str + " from APK");
                z11 = TPLoadLibFromApk.load(str, TPNativeLibraryLoader.class.getClassLoader(), context);
                if (z11) {
                    TPNativeLog.printLog(2, "loadLibDefault loaded " + str + " from APK successfully");
                } else {
                    TPNativeLog.printLog(4, "loadLibDefault loaded " + str + " from APK failed");
                }
            } catch (Throwable th3) {
                TPNativeLog.printLog(4, "loadLibDefault loaded " + str + " from APK failed," + th3.getMessage());
            }
        }
        return z11;
    }

    public static void loadLibIfNeeded(Context context) {
        synchronized (mIsLibLoadedLock) {
            if (!mIsLibLoaded) {
                boolean loadLib = loadLib(context);
                mIsLibLoaded = loadLib;
                TPNativeLog.printLog(2, loadLib ? "TPNativeLibraryLoader load lib successfully" : "TPNativeLibraryLoader load lib failed");
            }
            if (!mIsLibLoaded) {
                throw new UnsupportedOperationException("Failed to load native library");
            }
        }
    }

    public static void setLibLoader(ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader) {
        mLibLoader = iTPNativeLibraryExternalLoader;
    }
}
