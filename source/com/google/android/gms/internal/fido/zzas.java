package com.google.android.gms.internal.fido;

import java.util.List;

final class zzas extends zzat {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzat zzc;

    public zzas(zzat zzat, int i11, int i12) {
        this.zzc = zzat;
        this.zza = i11;
        this.zzb = i12;
    }

    public final Object get(int i11) {
        zzam.zza(i11, this.zzb, "index");
        return this.zzc.get(i11 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i11, int i12) {
        return subList(i11, i12);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzat zzf(int i11, int i12) {
        zzam.zze(i11, i12, this.zzb);
        zzat zzat = this.zzc;
        int i13 = this.zza;
        return zzat.subList(i11 + i13, i12 + i13);
    }
}
