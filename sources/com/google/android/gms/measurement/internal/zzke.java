package com.google.android.gms.measurement.internal;

final class zzke implements Runnable {
    public final /* synthetic */ zzlh zza;
    public final /* synthetic */ Runnable zzb;

    public zzke(zzkg zzkg, zzlh zzlh, Runnable runnable) {
        this.zza = zzlh;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
