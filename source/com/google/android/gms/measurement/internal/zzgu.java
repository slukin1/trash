package com.google.android.gms.measurement.internal;

final class zzgu implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzgv zze;

    public zzgu(zzgv zzgv, String str, String str2, String str3, long j11) {
        this.zze = zzgv;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j11;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzR(this.zzb, (zzir) null);
            return;
        }
        this.zze.zza.zzR(this.zzb, new zzir(this.zzc, str, this.zzd));
    }
}
