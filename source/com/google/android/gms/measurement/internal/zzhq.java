package com.google.android.gms.measurement.internal;

final class zzhq implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzik zze;

    public zzhq(zzik zzik, String str, String str2, Object obj, long j11) {
        this.zze = zzik;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j11;
    }

    public final void run() {
        this.zze.zzY(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
