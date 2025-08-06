package com.google.android.gms.measurement.internal;

final class zzjj extends zzan {
    public final /* synthetic */ zzjz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzjj(zzjz zzjz, zzgy zzgy) {
        super(zzgy);
        this.zza = zzjz;
    }

    public final void zzc() {
        zzjz zzjz = this.zza;
        zzjz.zzg();
        if (zzjz.zzL()) {
            zzjz.zzt.zzaA().zzj().zza("Inactivity, disconnecting from the service");
            zzjz.zzs();
        }
    }
}
