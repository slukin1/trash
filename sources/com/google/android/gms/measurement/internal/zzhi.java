package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcl;

public final class zzhi {
    public final Context zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public Boolean zze;
    public long zzf;
    public zzcl zzg;
    public boolean zzh = true;
    public final Long zzi;
    public String zzj;

    public zzhi(Context context, zzcl zzcl, Long l11) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
        this.zzi = l11;
        if (zzcl != null) {
            this.zzg = zzcl;
            this.zzb = zzcl.zzf;
            this.zzc = zzcl.zze;
            this.zzd = zzcl.zzd;
            this.zzh = zzcl.zzc;
            this.zzf = zzcl.zzb;
            this.zzj = zzcl.zzh;
            Bundle bundle = zzcl.zzg;
            if (bundle != null) {
                this.zze = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
