package com.google.android.gms.measurement.internal;

final class zzix implements Runnable {
    public final /* synthetic */ zzir zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zziz zzc;

    public zzix(zziz zziz, zzir zzir, long j11) {
        this.zzc = zziz;
        this.zza = zzir;
        this.zzb = j11;
    }

    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zziz zziz = this.zzc;
        zziz.zza = null;
        zziz.zzt.zzt().zzG((zzir) null);
    }
}
