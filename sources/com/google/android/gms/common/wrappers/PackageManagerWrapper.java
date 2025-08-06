package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.c;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public class PackageManagerWrapper {
    public final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(String str) {
        return this.zza.checkCallingOrSelfPermission(str);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public int checkPermission(String str, String str2) {
        return this.zza.getPackageManager().checkPermission(str, str2);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i11) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getApplicationInfo(str, i11);
    }

    @KeepForSdk
    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        Context context = this.zza;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public c<CharSequence, Drawable> getApplicationLabelAndIcon(String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.zza.getPackageManager().getApplicationInfo(str, 0);
        return c.a(this.zza.getPackageManager().getApplicationLabel(applicationInfo), this.zza.getPackageManager().getApplicationIcon(applicationInfo));
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i11) throws PackageManager.NameNotFoundException {
        return this.zza.getPackageManager().getPackageInfo(str, i11);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zza);
        }
        if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.zza.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean zza(int i11, String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.zza.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i11, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.zza.getPackageManager().getPackagesForUid(i11);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
