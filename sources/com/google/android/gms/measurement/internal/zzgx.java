package com.google.android.gms.measurement.internal;

abstract class zzgx extends zzgw {
    private boolean zza;

    public zzgx(zzgd zzgd) {
        super(zzgd);
        this.zzt.zzD();
    }

    public void zzaC() {
    }

    public abstract boolean zzf();

    public final void zzv() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzf()) {
            this.zzt.zzB();
            this.zza = true;
        }
    }

    public final void zzx() {
        if (!this.zza) {
            zzaC();
            this.zzt.zzB();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzy() {
        return this.zza;
    }
}
