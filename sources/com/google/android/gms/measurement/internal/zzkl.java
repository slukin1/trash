package com.google.android.gms.measurement.internal;

final class zzkl {
    public final /* synthetic */ zzkp zza;
    private zzkk zzb;

    public zzkl(zzkp zzkp) {
        this.zza = zzkp;
    }

    public final void zza(long j11) {
        this.zzb = new zzkk(this, this.zza.zzt.zzax().currentTimeMillis(), j11);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    public final void zzb() {
        this.zza.zzg();
        zzkk zzkk = this.zzb;
        if (zzkk != null) {
            this.zza.zzd.removeCallbacks(zzkk);
        }
        this.zza.zzt.zzm().zzm.zza(false);
        this.zza.zzm(false);
    }
}
