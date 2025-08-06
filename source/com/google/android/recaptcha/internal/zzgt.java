package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzgt extends zzgs {
    public final byte[] zza;

    public zzgt(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgw) || zzd() != ((zzgw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgt)) {
            return obj.equals(this);
        }
        zzgt zzgt = (zzgt) obj;
        int zzl = zzl();
        int zzl2 = zzgt.zzl();
        if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzgt.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzgt.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzgt.zza;
            zzgt.zzc();
            int i11 = 0;
            int i12 = 0;
            while (i11 < zzd) {
                if (bArr[i11] != bArr2[i12]) {
                    return false;
                }
                i11++;
                i12++;
            }
            return true;
        } else {
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzgt.zzd());
        }
    }

    public byte zza(int i11) {
        return this.zza[i11];
    }

    public byte zzb(int i11) {
        return this.zza[i11];
    }

    public int zzc() {
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, 0, bArr, 0, i13);
    }

    public final int zzf(int i11, int i12, int i13) {
        return zzjc.zzb(i11, this.zza, 0, i13);
    }

    public final zzgw zzg(int i11, int i12) {
        int zzk = zzgw.zzk(0, i12, zzd());
        if (zzk == 0) {
            return zzgw.zzb;
        }
        return new zzgq(this.zza, 0, zzk);
    }

    public final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzi(zzgm zzgm) throws IOException {
        ((zzhe) zzgm).zzc(this.zza, 0, zzd());
    }

    public final boolean zzj() {
        return zzma.zzf(this.zza, 0, zzd());
    }
}
