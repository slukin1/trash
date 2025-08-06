package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzj == null) {
            boolean z11 = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z11 = true;
            }
            zzj = Boolean.valueOf(z11);
        }
        return zzj.booleanValue();
    }

    @KeepForSdk
    public static boolean isBstar(Context context) {
        if (zzm == null) {
            boolean z11 = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z11 = true;
            }
            zzm = Boolean.valueOf(z11);
        }
        return zzm.booleanValue();
    }

    @KeepForSdk
    public static boolean isFoldable(Context context) {
        if (zzc == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            boolean z11 = false;
            if (!(!PlatformVersion.isAtLeastR() || sensorManager == null || sensorManager.getDefaultSensor(36) == null)) {
                z11 = true;
            }
            zzc = Boolean.valueOf(z11);
        }
        return zzc.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context) {
        if (zzg == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z11 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z11 = true;
            }
            zzg = Boolean.valueOf(z11);
        }
        return zzg.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (isXr(r4) == false) goto L_0x0070;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isPhone(android.content.Context r4) {
        /*
            java.lang.Boolean r0 = zza
            if (r0 != 0) goto L_0x0076
            boolean r0 = isFoldable(r4)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0070
            boolean r0 = isTablet((android.content.Context) r4)
            if (r0 != 0) goto L_0x006f
            boolean r0 = isWearable(r4)
            if (r0 != 0) goto L_0x006f
            boolean r0 = zzb(r4)
            if (r0 != 0) goto L_0x006f
            java.lang.Boolean r0 = zzi
            if (r0 != 0) goto L_0x0032
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "org.chromium.arc"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            zzi = r0
        L_0x0032:
            java.lang.Boolean r0 = zzi
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x006f
            boolean r0 = isAuto(r4)
            if (r0 != 0) goto L_0x006f
            boolean r0 = isTv(r4)
            if (r0 != 0) goto L_0x006f
            java.lang.Boolean r0 = zzl
            if (r0 != 0) goto L_0x005a
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "com.google.android.feature.AMATI_EXPERIENCE"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            zzl = r0
        L_0x005a:
            java.lang.Boolean r0 = zzl
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x006f
            boolean r0 = isBstar(r4)
            if (r0 != 0) goto L_0x006f
            boolean r4 = isXr(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r1 = r2
        L_0x0070:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            zza = r4
        L_0x0076:
            java.lang.Boolean r4 = zza
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isPhone(android.content.Context):boolean");
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(Context context) {
        return zzc(context.getResources());
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(Context context) {
        return zza(context);
    }

    @KeepForSdk
    public static boolean isTablet(Context context) {
        return isTablet(context.getResources());
    }

    @KeepForSdk
    public static boolean isTv(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzk == null) {
            boolean z11 = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z11 = false;
            }
            zzk = Boolean.valueOf(z11);
        }
        return zzk.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        int i11 = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(Context context) {
        return zzd(context.getPackageManager());
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zza(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    @KeepForSdk
    public static boolean isXr(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzn == null) {
            zzn = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.immersive"));
        }
        return zzn.booleanValue();
    }

    @TargetApi(21)
    public static boolean zza(Context context) {
        if (zzf == null) {
            boolean z11 = false;
            if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z11 = true;
            }
            zzf = Boolean.valueOf(z11);
        }
        return zzf.booleanValue();
    }

    public static boolean zzb(Context context) {
        if (zzh == null) {
            boolean z11 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z11 = false;
            }
            zzh = Boolean.valueOf(z11);
        }
        return zzh.booleanValue();
    }

    public static boolean zzc(Resources resources) {
        boolean z11 = false;
        if (resources == null) {
            return false;
        }
        if (zzd == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z11 = true;
            }
            zzd = Boolean.valueOf(z11);
        }
        return zzd.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean zzd(PackageManager packageManager) {
        if (zze == null) {
            boolean z11 = false;
            if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z11 = true;
            }
            zze = Boolean.valueOf(z11);
        }
        return zze.booleanValue();
    }

    @KeepForSdk
    public static boolean isTablet(Resources resources) {
        boolean z11 = false;
        if (resources == null) {
            return false;
        }
        if (zzb == null) {
            if ((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources)) {
                z11 = true;
            }
            zzb = Boolean.valueOf(z11);
        }
        return zzb.booleanValue();
    }
}
