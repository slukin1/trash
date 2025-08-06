package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzdt {
    public static int zza(byte[] bArr, int i11, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i11, zzds);
        int i12 = zzds.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        } else if (i12 > bArr.length - zzj) {
            throw zzfa.zzf();
        } else if (i12 == 0) {
            zzds.zzc = zzee.zzb;
            return zzj;
        } else {
            zzds.zzc = zzee.zzk(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int zzc(zzgh zzgh, byte[] bArr, int i11, int i12, int i13, zzds zzds) throws IOException {
        zzfz zzfz = (zzfz) zzgh;
        Object zzd = zzfz.zzd();
        int zzb = zzfz.zzb(zzd, bArr, i11, i12, i13, zzds);
        zzfz.zze(zzd);
        zzds.zzc = zzd;
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzd(com.google.android.gms.internal.auth.zzgh r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.auth.zzds r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zzd()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzg(r1, r2, r3, r4, r5)
            r6.zze(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.auth.zzfa r6 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzdt.zzd(com.google.android.gms.internal.auth.zzgh, byte[], int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    public static int zze(zzgh zzgh, int i11, byte[] bArr, int i12, int i13, zzey zzey, zzds zzds) throws IOException {
        int zzd = zzd(zzgh, bArr, i12, i13, zzds);
        zzey.add(zzds.zzc);
        while (zzd < i13) {
            int zzj = zzj(bArr, zzd, zzds);
            if (i11 != zzds.zza) {
                break;
            }
            zzd = zzd(zzgh, bArr, zzj, i13, zzds);
            zzey.add(zzds.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzey zzey, zzds zzds) throws IOException {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i11, zzds);
        int i12 = zzds.zza + zzj;
        while (zzj < i12) {
            zzj = zzj(bArr, zzj, zzds);
            zzev.zze(zzds.zza);
        }
        if (zzj == i12) {
            return zzj;
        }
        throw zzfa.zzf();
    }

    public static int zzg(byte[] bArr, int i11, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i11, zzds);
        int i12 = zzds.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        } else if (i12 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = new String(bArr, zzj, i12, zzez.zzb);
            return zzj + i12;
        }
    }

    public static int zzh(byte[] bArr, int i11, zzds zzds) throws zzfa {
        int zzj = zzj(bArr, i11, zzds);
        int i12 = zzds.zza;
        if (i12 < 0) {
            throw zzfa.zzc();
        } else if (i12 == 0) {
            zzds.zzc = "";
            return zzj;
        } else {
            zzds.zzc = zzhm.zzb(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzi(int i11, byte[] bArr, int i12, int i13, zzgz zzgz, zzds zzds) throws zzfa {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzm = zzm(bArr, i12, zzds);
                zzgz.zzf(i11, Long.valueOf(zzds.zzb));
                return zzm;
            } else if (i14 == 1) {
                zzgz.zzf(i11, Long.valueOf(zzn(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzj = zzj(bArr, i12, zzds);
                int i15 = zzds.zza;
                if (i15 < 0) {
                    throw zzfa.zzc();
                } else if (i15 <= bArr.length - zzj) {
                    if (i15 == 0) {
                        zzgz.zzf(i11, zzee.zzb);
                    } else {
                        zzgz.zzf(i11, zzee.zzk(bArr, zzj, i15));
                    }
                    return zzj + i15;
                } else {
                    throw zzfa.zzf();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zzgz zzc = zzgz.zzc();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i12, zzds);
                    int i18 = zzds.zza;
                    if (i18 == i16) {
                        i17 = i18;
                        i12 = zzj2;
                        break;
                    }
                    i17 = i18;
                    i12 = zzi(i18, bArr, zzj2, i13, zzc, zzds);
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzfa.zzd();
                }
                zzgz.zzf(i11, zzc);
                return i12;
            } else if (i14 == 5) {
                zzgz.zzf(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzfa.zza();
            }
        } else {
            throw zzfa.zza();
        }
    }

    public static int zzj(byte[] bArr, int i11, zzds zzds) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzds);
        }
        zzds.zza = b11;
        return i12;
    }

    public static int zzk(int i11, byte[] bArr, int i12, zzds zzds) {
        int i13 = i11 & 127;
        int i14 = i12 + 1;
        byte b11 = bArr[i12];
        if (b11 >= 0) {
            zzds.zza = i13 | (b11 << 7);
            return i14;
        }
        int i15 = i13 | ((b11 & Ascii.DEL) << 7);
        int i16 = i14 + 1;
        byte b12 = bArr[i14];
        if (b12 >= 0) {
            zzds.zza = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzds.zza = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzds.zza = i19 | (b14 << 28);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzds.zza = i22;
                return i23;
            }
        }
    }

    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzey zzey, zzds zzds) {
        zzev zzev = (zzev) zzey;
        int zzj = zzj(bArr, i12, zzds);
        zzev.zze(zzds.zza);
        while (zzj < i13) {
            int zzj2 = zzj(bArr, zzj, zzds);
            if (i11 != zzds.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzds);
            zzev.zze(zzds.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i11, zzds zzds) {
        int i12 = i11 + 1;
        long j11 = (long) bArr[i11];
        if (j11 >= 0) {
            zzds.zzb = j11;
            return i12;
        }
        int i13 = i12 + 1;
        byte b11 = bArr[i12];
        long j12 = (j11 & 127) | (((long) (b11 & Ascii.DEL)) << 7);
        int i14 = 7;
        while (b11 < 0) {
            int i15 = i13 + 1;
            byte b12 = bArr[i13];
            i14 += 7;
            j12 |= ((long) (b12 & Ascii.DEL)) << i14;
            int i16 = i15;
            b11 = b12;
            i13 = i16;
        }
        zzds.zzb = j12;
        return i13;
    }

    public static long zzn(byte[] bArr, int i11) {
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }
}
