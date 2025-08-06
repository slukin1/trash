package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zznl {
    private static final zznl zza = new zznl(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zznl() {
        this(0, new int[8], new Object[8], true);
    }

    private zznl(int i11, int[] iArr, Object[] objArr, boolean z11) {
        this.zze = -1;
        this.zzb = i11;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z11;
    }

    public static zznl zzc() {
        return zza;
    }

    public static zznl zze(zznl zznl, zznl zznl2) {
        int i11 = zznl.zzb + zznl2.zzb;
        int[] copyOf = Arrays.copyOf(zznl.zzc, i11);
        System.arraycopy(zznl2.zzc, 0, copyOf, zznl.zzb, zznl2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zznl.zzd, i11);
        System.arraycopy(zznl2.zzd, 0, copyOf2, zznl.zzb, zznl2.zzb);
        return new zznl(i11, copyOf, copyOf2, true);
    }

    public static zznl zzf() {
        return new zznl(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i11) {
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
        if (obj == null || !(obj instanceof zznl)) {
            return false;
        }
        zznl zznl = (zznl) obj;
        int i11 = this.zzb;
        if (i11 == zznl.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zznl.zzc;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zznl.zzd;
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
        int i16 = (i12 * 31) + i14;
        Object[] objArr = this.zzd;
        int i17 = this.zzb;
        for (int i18 = 0; i18 < i17; i18++) {
            i13 = (i13 * 31) + objArr[i18].hashCode();
        }
        return (i16 * 31) + i13;
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
                    i11 = zzki.zzx(i18 << 3) + 8;
                } else if (i19 == 2) {
                    int i21 = zzki.zzb;
                    int zzd2 = ((zzka) this.zzd[i16]).zzd();
                    i11 = zzki.zzx(i18 << 3) + zzki.zzx(zzd2) + zzd2;
                } else if (i19 == 3) {
                    int i22 = i18 << 3;
                    int i23 = zzki.zzb;
                    i12 = ((zznl) this.zzd[i16]).zza();
                    int zzx = zzki.zzx(i22);
                    i13 = zzx + zzx;
                } else if (i19 == 5) {
                    ((Integer) this.zzd[i16]).intValue();
                    i11 = zzki.zzx(i18 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzll.zza());
                }
                i15 += i11;
            } else {
                int i24 = i18 << 3;
                i12 = zzki.zzy(((Long) this.zzd[i16]).longValue());
                i13 = zzki.zzx(i24);
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
            int i14 = zzki.zzb;
            int zzd2 = ((zzka) this.zzd[i13]).zzd();
            int zzx = zzki.zzx(zzd2) + zzd2;
            int zzx2 = zzki.zzx(16);
            int zzx3 = zzki.zzx(this.zzc[i13] >>> 3);
            int zzx4 = zzki.zzx(8);
            i12 += zzx4 + zzx4 + zzx2 + zzx3 + zzki.zzx(24) + zzx;
        }
        this.zze = i12;
        return i12;
    }

    public final zznl zzd(zznl zznl) {
        if (zznl.equals(zza)) {
            return this;
        }
        zzg();
        int i11 = this.zzb + zznl.zzb;
        zzl(i11);
        System.arraycopy(zznl.zzc, 0, this.zzc, this.zzb, zznl.zzb);
        System.arraycopy(zznl.zzd, 0, this.zzd, this.zzb, zznl.zzb);
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
            zzmk.zzb(sb2, i11, String.valueOf(this.zzc[i12] >>> 3), this.zzd[i12]);
        }
    }

    public final void zzj(int i11, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i12 = this.zzb;
        iArr[i12] = i11;
        this.zzd[i12] = obj;
        this.zzb = i12 + 1;
    }

    public final void zzk(zzoc zzoc) throws IOException {
        if (this.zzb != 0) {
            for (int i11 = 0; i11 < this.zzb; i11++) {
                int i12 = this.zzc[i11];
                Object obj = this.zzd[i11];
                int i13 = i12 & 7;
                int i14 = i12 >>> 3;
                if (i13 == 0) {
                    zzoc.zzt(i14, ((Long) obj).longValue());
                } else if (i13 == 1) {
                    zzoc.zzm(i14, ((Long) obj).longValue());
                } else if (i13 == 2) {
                    zzoc.zzd(i14, (zzka) obj);
                } else if (i13 == 3) {
                    zzoc.zzE(i14);
                    ((zznl) obj).zzk(zzoc);
                    zzoc.zzh(i14);
                } else if (i13 == 5) {
                    zzoc.zzk(i14, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzll.zza());
                }
            }
        }
    }
}
