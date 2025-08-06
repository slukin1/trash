package com.google.android.gms.measurement.internal;

final class zzkx implements Runnable {
    public final /* synthetic */ zzli zza;
    public final /* synthetic */ zzlh zzb;

    public zzkx(zzlh zzlh, zzli zzli) {
        this.zzb = zzlh;
        this.zza = zzli;
    }

    public final void run() {
        zzlh.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
