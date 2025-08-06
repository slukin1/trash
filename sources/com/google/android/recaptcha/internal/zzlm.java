package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzlm {
    private static final zzlm zza = new zzlm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzlm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzlm(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z11;
    }

    public static zzlm zzc() {
        return zza;
    }

    public static zzlm zze(zzlm zzlm, zzlm zzlm2) {
        int i11 = zzlm.zzb + zzlm2.zzb;
        int[] copyOf = Arrays.copyOf(zzlm.zzc, i11);
        System.arraycopy(zzlm2.zzc, 0, copyOf, zzlm.zzb, zzlm2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzlm.zzd, i11);
        System.arraycopy(zzlm2.zzd, 0, copyOf2, zzlm.zzb, zzlm2.zzb);
        return new zzlm(i11, copyOf, copyOf2, true);
    }

    public static zzlm zzf() {
        return new zzlm(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i11) {
        int[] iArr = this.zzc;
        if (i11 > iArr.length) {
            int i12 = this.zzb;
            int i13 = i12 + (i12 / 2);
            if (i13 >= i11) {
                i11 = i13;
            }
            if (i11 < 8) {
                i11 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i11);
            this.zzd = Arrays.copyOf(this.zzd, i11);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzlm)) {
            return false;
        }
        zzlm zzlm = (zzlm) obj;
        int i11 = this.zzb;
        if (i11 == zzlm.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzlm.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzlm.zzd;
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
        int i12 = i11 + 527;
        int[] iArr = this.zzc;
        int i13 = 17;
        int i14 = 17;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 = (i14 * 31) + iArr[i15];
        }
        int i16 = ((i12 * 31) + i14) * 31;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return i16 + i13;
    }

    public final int zza() {
        int i11;
        int i12;
        int i13;
        int i14 = this.zze;
        if (i14 != -1) {
            return i14;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < this.zzb; i16++) {
            int i17 = this.zzc[i16];
            int i18 = i17 >>> 3;
            int i19 = i17 & 7;
            if (i19 != 0) {
                if (i19 == 1) {
                    ((Long) this.zzd[i16]).longValue();
                    i11 = zzhh.zzy(i18 << 3) + 8;
                } else if (i19 == 2) {
                    int i21 = i18 << 3;
                    int i22 = zzhh.zzb;
                    int zzd2 = ((zzgw) this.zzd[i16]).zzd();
                    i11 = zzhh.zzy(i21) + zzhh.zzy(zzd2) + zzd2;
                } else if (i19 == 3) {
                    int i23 = i18 << 3;
                    int i24 = zzhh.zzb;
                    i12 = ((zzlm) this.zzd[i16]).zza();
                    int zzy = zzhh.zzy(i23);
                    i13 = zzy + zzy;
                } else if (i19 == 5) {
                    ((Integer) this.zzd[i16]).intValue();
                    i11 = zzhh.zzy(i18 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzje.zza());
                }
                i15 += i11;
            } else {
                int i25 = i18 << 3;
                i12 = zzhh.zzz(((Long) this.zzd[i16]).longValue());
                i13 = zzhh.zzy(i25);
            }
            i11 = i13 + i12;
            i15 += i11;
        }
        this.zze = i15;
        return i15;
    }

    public final int zzb() {
        int i11 = this.zze;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzb; i13++) {
            int i14 = zzhh.zzb;
            int zzd2 = ((zzgw) this.zzd[i13]).zzd();
            int zzy = zzhh.zzy(zzd2) + zzd2;
            int zzy2 = zzhh.zzy(16);
            int zzy3 = zzhh.zzy(this.zzc[i13] >>> 3);
            int zzy4 = zzhh.zzy(8);
            i12 += zzy4 + zzy4 + zzy2 + zzy3 + zzhh.zzy(24) + zzy;
        }
        this.zze = i12;
        return i12;
    }

    public final zzlm zzd(zzlm zzlm) {
        if (zzlm.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zzlm.zzb;
        zzm(i11);
        System.arraycopy(zzlm.zzc, 0, this.zzc, this.zzb, zzlm.zzb);
        System.arraycopy(zzlm.zzd, 0, this.zzd, this.zzb, zzlm.zzb);
        this.zzb = i11;
        return this;
    }

    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < this.zzb; i12++) {
            zzkg.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzj(int i11, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    public final void zzk(zzmd zzmd) throws IOException {
        for (int i11 = 0; i11 < this.zzb; i11++) {
            zzmd.zzw(this.zzc[i11] >>> 3, this.zzd[i11]);
        }
    }

    public final void zzl(zzmd zzmd) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 & 7;
                int i14 = i12 >>> 3;
                if (i13 == 0) {
                    zzmd.zzt(i14, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zzmd.zzm(i14, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zzmd.zzd(i14, (zzgw) obj);
                } else if (i13 == 3) {
                    zzmd.zzF(i14);
                    ((zzlm) obj).zzl(zzmd);
                    zzmd.zzh(i14);
                } else if (i13 == 5) {
                    zzmd.zzk(i14, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzje.zza());
                }
            }
        }
    }
}
