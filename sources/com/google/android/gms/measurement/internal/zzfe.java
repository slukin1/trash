package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfe {
    public final /* synthetic */ zzfi zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzfe(zzfi zzfi, String str, long j11) {
        this.zza = zzfi;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j11;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j11) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j11);
        edit.apply();
        this.zze = j11;
    }
}
