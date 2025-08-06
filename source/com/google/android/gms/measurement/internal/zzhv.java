package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhv implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzik zzd;

    public zzhv(zzik zzik, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzd = zzik;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void run() {
        this.zzd.zzt.zzt().zzw(this.zza, (String) null, this.zzb, this.zzc);
    }
}
