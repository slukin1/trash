package com.google.android.gms.measurement.internal;

final class zzfa implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzfb zzb;

    public zzfa(zzfb zzfb, boolean z11) {
        this.zzb = zzfb;
        this.zza = z11;
    }

    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
