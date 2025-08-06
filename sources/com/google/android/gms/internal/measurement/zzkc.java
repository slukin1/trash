package com.google.android.gms.internal.measurement;

final class zzkc extends zzke {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze = Integer.MAX_VALUE;

    public /* synthetic */ zzkc(byte[] bArr, int i11, int i12, boolean z11, zzkb zzkb) {
        super((zzkd) null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i11) throws zzll {
        int i12 = this.zze;
        this.zze = 0;
        int i13 = this.zzc + this.zzd;
        this.zzc = i13;
        if (i13 > 0) {
            this.zzd = i13;
            this.zzc = i13 - i13;
        } else {
            this.zzd = 0;
        }
        return i12;
    }
}
