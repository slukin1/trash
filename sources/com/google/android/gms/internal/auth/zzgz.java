package com.google.android.gms.internal.auth;

import java.util.Arrays;

public final class zzgz {
    private static final zzgz zza = new zzgz(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    private zzgz() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgz(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z11;
    }

    public static zzgz zza() {
        return zza;
    }

    public static zzgz zzb(zzgz zzgz, zzgz zzgz2) {
        int i11 = zzgz.zzb + zzgz2.zzb;
        int[] copyOf = Arrays.copyOf(zzgz.zzc, i11);
        System.arraycopy(zzgz2.zzc, 0, copyOf, zzgz.zzb, zzgz2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgz.zzd, i11);
        System.arraycopy(zzgz2.zzd, 0, copyOf2, zzgz.zzb, zzgz2.zzb);
        return new zzgz(i11, copyOf, copyOf2, true);
    }

    public static zzgz zzc() {
        return new zzgz(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgz)) {
            return false;
        }
        zzgz zzgz = (zzgz) obj;
        int i11 = this.zzb;
        if (i11 == zzgz.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgz.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgz.zzd;
                    int i13 = this.zzb;
                    int i14 = 0;
                    while (i14 < i13) {
                        if (objArr[i14].equals(objArr2[i14])) {
                            i14++;
                        }
                    }
                    return true;
                } else if (iArr[i12] != iArr2[i12]) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzb;
        int i12 = (i11 + 527) * 31;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = (i12 + i14) * 31;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final void zzd() {
        this.zze = false;
    }

    public final void zze(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzfy.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzf(int i11, Object obj) {
        if (this.zze) {
            int i12 = this.zzb;
            int[] iArr = this.zzc;
            if (i12 == iArr.length) {
                int i13 = i12 + (i12 < 4 ? 8 : i12 >> 1);
                this.zzc = Arrays.copyOf(iArr, i13);
                this.zzd = Arrays.copyOf(this.zzd, i13);
            }
            int[] iArr2 = this.zzc;
            int i14 = this.zzb;
            iArr2[i14] = i11;
            this.zzd[i14] = obj;
            this.zzb = i14 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
