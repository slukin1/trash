package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzfl {
    public final zzgd zza;

    public zzfl(zzlh zzlh) {
        this.zza = zzlh.zzp();
    }

    public final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzaw());
            if (packageManager == null) {
                this.zza.zzaA().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e11) {
            this.zza.zzaA().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e11);
            return false;
        }
    }
}
