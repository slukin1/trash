package com.google.android.gms.measurement.internal;

abstract class zzf extends zze {
    private boolean zza;

    public zzf(zzgd zzgd) {
        super(zzgd);
        this.zzt.zzD();
    }

    public final void zza() {
        if (!zze()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzb() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzt.zzB();
            this.zza = true;
        }
    }

    public final void zzc() {
        if (!this.zza) {
            zzd();
            this.zzt.zzB();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public void zzd() {
    }

    public final boolean zze() {
        return this.zza;
    }

    public abstract boolean zzf();
}
