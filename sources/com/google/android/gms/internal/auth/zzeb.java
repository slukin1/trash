package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;
import java.util.Objects;

class zzeb extends zzea {
    public final byte[] zza;

    public zzeb(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || zzd() != ((zzee) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return obj.equals(this);
        }
        zzeb zzeb = (zzeb) obj;
        int zzj = zzj();
        int zzj2 = zzeb.zzj();
        if (zzj != 0 && zzj2 != 0 && zzj != zzj2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzeb.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzeb.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzeb.zza;
            zzeb.zzc();
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
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzeb.zzd());
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
        return zzez.zzd(i11, this.zza, 0, i13);
    }

    public final zzee zzf(int i11, int i12) {
        int zzi = zzee.zzi(0, i12, zzd());
        if (zzi == 0) {
            return zzee.zzb;
        }
        return new zzdy(this.zza, 0, zzi);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final boolean zzh() {
        return zzhm.zzd(this.zza, 0, zzd());
    }
}
