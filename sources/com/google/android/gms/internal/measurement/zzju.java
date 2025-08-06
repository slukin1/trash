package com.google.android.gms.internal.measurement;

final class zzju extends zzjx {
    private final int zzc;

    public zzju(byte[] bArr, int i11, int i12) {
        super(bArr);
        zzka.zzj(0, i12, bArr.length);
        this.zzc = i12;
    }

    public final byte zza(int i11) {
        int i12 = this.zzc;
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return this.zza[i11];
        }
        if (i11 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + ", " + i12);
    }

    public final byte zzb(int i11) {
        return this.zza[i11];
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }
}
