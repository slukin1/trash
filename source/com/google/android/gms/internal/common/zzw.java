package com.google.android.gms.internal.common;

abstract class zzw extends zzj {
    public final CharSequence zzb;
    public final zzo zzc;
    public final boolean zzd;
    public int zze = 0;
    public int zzf;

    public zzw(zzx zzx, CharSequence charSequence) {
        this.zzc = zzx.zza;
        this.zzd = zzx.zzb;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        int zzd2;
        int i11;
        int i12 = this.zze;
        while (true) {
            int i13 = this.zze;
            if (i13 != -1) {
                zzd2 = zzd(i13);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zze = -1;
                    i11 = -1;
                } else {
                    i11 = zzc(zzd2);
                    this.zze = i11;
                }
                if (i11 == i12) {
                    int i14 = i11 + 1;
                    this.zze = i14;
                    if (i14 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i12 < zzd2) {
                        this.zzb.charAt(i12);
                    }
                    if (i12 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    if (!this.zzd || i12 != zzd2) {
                        int i15 = this.zzf;
                    } else {
                        i12 = this.zze;
                    }
                }
            } else {
                zzb();
                return null;
            }
        }
        int i152 = this.zzf;
        if (i152 == 1) {
            zzd2 = this.zzb.length();
            this.zze = -1;
            if (zzd2 > i12) {
                this.zzb.charAt(zzd2 - 1);
            }
        } else {
            this.zzf = i152 - 1;
        }
        return this.zzb.subSequence(i12, zzd2).toString();
    }

    public abstract int zzc(int i11);

    public abstract int zzd(int i11);
}
