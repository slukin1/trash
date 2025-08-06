package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfc {
    public final /* synthetic */ zzfi zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzfc(zzfi zzfi, String str, boolean z11) {
        this.zza = zzfi;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z11;
    }

    public final void zza(boolean z11) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putBoolean(this.zzb, z11);
        edit.apply();
        this.zze = z11;
    }

    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
