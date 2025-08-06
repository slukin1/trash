package com.google.android.gms.measurement.internal;

public final /* synthetic */ class zzhl implements Runnable {
    public final /* synthetic */ zzik zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzhl(zzik zzik, String str) {
        this.zza = zzik;
        this.zzb = str;
    }

    public final void run() {
        zzik zzik = this.zza;
        if (zzik.zzt.zzh().zzp(this.zzb)) {
            zzik.zzt.zzh().zzo();
        }
    }
}
