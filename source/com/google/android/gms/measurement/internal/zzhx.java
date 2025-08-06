package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhx implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzik zze;

    public zzhx(zzik zzik, AtomicReference atomicReference, String str, String str2, String str3, boolean z11) {
        this.zze = zzik;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z11;
    }

    public final void run() {
        this.zze.zzt.zzt().zzz(this.zza, (String) null, this.zzb, this.zzc, this.zzd);
    }
}
