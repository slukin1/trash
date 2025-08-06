package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzjx extends zzjw {
    public final byte[] zza;

    public zzjx(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzka) || zzd() != ((zzka) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzjx)) {
            return obj.equals(this);
        }
        zzjx zzjx = (zzjx) obj;
        int zzk = zzk();
        int zzk2 = zzjx.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzjx.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzjx.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzjx.zza;
            zzjx.zzc();
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
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzjx.zzd());
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

    public final int zze(int i11, int i12, int i13) {
        return zzlj.zzb(i11, this.zza, 0, i13);
    }

    public final zzka zzf(int i11, int i12) {
        int zzj = zzka.zzj(0, i12, zzd());
        if (zzj == 0) {
            return zzka.zzb;
        }
        return new zzju(this.zza, 0, zzj);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zzjq zzjq) throws IOException {
        ((zzkf) zzjq).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zznz.zze(this.zza, 0, zzd());
    }
}
