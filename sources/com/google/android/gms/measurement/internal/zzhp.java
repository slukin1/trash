package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzhp implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ boolean zzg;
    public final /* synthetic */ String zzh;
    public final /* synthetic */ zzik zzi;

    public zzhp(zzik zzik, String str, String str2, long j11, Bundle bundle, boolean z11, boolean z12, boolean z13, String str3) {
        this.zzi = zzik;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
        this.zzd = bundle;
        this.zze = z11;
        this.zzf = z12;
        this.zzg = z13;
        this.zzh = str3;
    }

    public final void run() {
        this.zzi.zzI(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
