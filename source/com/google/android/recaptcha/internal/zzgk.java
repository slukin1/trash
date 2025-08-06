package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzgk {
    public static int zza(byte[] bArr, int i11, zzgj zzgj) throws zzje {
        int zzi = zzi(bArr, i11, zzgj);
        int i12 = zzgj.zza;
        if (i12 < 0) {
            throw zzje.zzf();
        } else if (i12 > bArr.length - zzi) {
            throw zzje.zzj();
        } else if (i12 == 0) {
            zzgj.zzc = zzgw.zzb;
            return zzi;
        } else {
            zzgj.zzc = zzgw.zzm(bArr, zzi, i12);
            return zzi + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int zzc(zzkr zzkr, byte[] bArr, int i11, int i12, int i13, zzgj zzgj) throws IOException {
        Object zze = zzkr.zze();
        int zzm = zzm(zze, zzkr, bArr, i11, i12, i13, zzgj);
        zzkr.zzf(zze);
        zzgj.zzc = zze;
        return zzm;
    }

    public static int zzd(zzkr zzkr, byte[] bArr, int i11, int i12, zzgj zzgj) throws IOException {
        Object zze = zzkr.zze();
        int zzn = zzn(zze, zzkr, bArr, i11, i12, zzgj);
        zzkr.zzf(zze);
        zzgj.zzc = zze;
        return zzn;
    }

    public static int zze(zzkr zzkr, int i11, byte[] bArr, int i12, int i13, zzjb zzjb, zzgj zzgj) throws IOException {
        int zzd = zzd(zzkr, bArr, i12, i13, zzgj);
        zzjb.add(zzgj.zzc);
        while (zzd < i13) {
            int zzi = zzi(bArr, zzd, zzgj);
            if (i11 != zzgj.zza) {
                break;
            }
            zzd = zzd(zzkr, bArr, zzi, i13, zzgj);
            zzjb.add(zzgj.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzjb zzjb, zzgj zzgj) throws IOException {
        zziu zziu = (zziu) zzjb;
        int zzi = zzi(bArr, i11, zzgj);
        int i12 = zzgj.zza + zzi;
        while (zzi < i12) {
            zzi = zzi(bArr, zzi, zzgj);
            zziu.zzg(zzgj.zza);
        }
        if (zzi == i12) {
            return zzi;
        }
        throw zzje.zzj();
    }

    public static int zzg(byte[] bArr, int i11, zzgj zzgj) throws zzje {
        int zzi = zzi(bArr, i11, zzgj);
        int i12 = zzgj.zza;
        if (i12 < 0) {
            throw zzje.zzf();
        } else if (i12 == 0) {
            zzgj.zzc = "";
            return zzi;
        } else {
            zzgj.zzc = new String(bArr, zzi, i12, zzjc.zzb);
            return zzi + i12;
        }
    }

    public static int zzh(int i11, byte[] bArr, int i12, int i13, zzlm zzlm, zzgj zzgj) throws zzje {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzl = zzl(bArr, i12, zzgj);
                zzlm.zzj(i11, Long.valueOf(zzgj.zzb));
                return zzl;
            } else if (i14 == 1) {
                zzlm.zzj(i11, Long.valueOf(zzp(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzi = zzi(bArr, i12, zzgj);
                int i15 = zzgj.zza;
                if (i15 < 0) {
                    throw zzje.zzf();
                } else if (i15 <= bArr.length - zzi) {
                    if (i15 == 0) {
                        zzlm.zzj(i11, zzgw.zzb);
                    } else {
                        zzlm.zzj(i11, zzgw.zzm(bArr, zzi, i15));
                    }
                    return zzi + i15;
                } else {
                    throw zzje.zzj();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zzlm zzf = zzlm.zzf();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzi2 = zzi(bArr, i12, zzgj);
                    int i18 = zzgj.zza;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zzi2;
                        break;
                    }
                    int zzh = zzh(i17, bArr, zzi2, i13, zzf, zzgj);
                    i17 = i18;
                    i12 = zzh;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzje.zzg();
                }
                zzlm.zzj(i11, zzf);
                return i12;
            } else if (i14 == 5) {
                zzlm.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzje.zzc();
            }
        } else {
            throw zzje.zzc();
        }
    }

    public static int zzi(byte[] bArr, int i11, zzgj zzgj) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzj(b11, bArr, i12, zzgj);
        }
        zzgj.zza = b11;
        return i12;
    }

    public static int zzj(int i11, byte[] bArr, int i12, zzgj zzgj) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzgj.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Ascii.DEL) << 7);
        int i16 = i13 + 1;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzgj.zza = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzgj.zza = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzgj.zza = i19 | (b14 << 28);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzgj.zza = i22;
                return i23;
            }
        }
    }

    public static int zzk(int i11, byte[] bArr, int i12, int i13, zzjb zzjb, zzgj zzgj) {
        zziu zziu = (zziu) zzjb;
        int zzi = zzi(bArr, i12, zzgj);
        zziu.zzg(zzgj.zza);
        while (zzi < i13) {
            int zzi2 = zzi(bArr, zzi, zzgj);
            if (i11 != zzgj.zza) {
                break;
            }
            zzi = zzi(bArr, zzi2, zzgj);
            zziu.zzg(zzgj.zza);
        }
        return zzi;
    }

    public static int zzl(byte[] bArr, int i11, zzgj zzgj) {
        long j11 = (long) bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzgj.zzb = j11;
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
            byte b13 = b12;
            i13 = i15;
            b11 = b13;
        }
        zzgj.zzb = j12;
        return i13;
    }

    public static int zzm(Object obj, zzkr zzkr, byte[] bArr, int i11, int i12, int i13, zzgj zzgj) throws IOException {
        int zzc = ((zzkh) zzkr).zzc(obj, bArr, i11, i12, i13, zzgj);
        zzgj.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzn(java.lang.Object r6, com.google.android.recaptcha.internal.zzkr r7, byte[] r8, int r9, int r10, com.google.android.recaptcha.internal.zzgj r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzj(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.recaptcha.internal.zzje r6 = com.google.android.recaptcha.internal.zzje.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgk.zzn(java.lang.Object, com.google.android.recaptcha.internal.zzkr, byte[], int, int, com.google.android.recaptcha.internal.zzgj):int");
    }

    public static int zzo(int i11, byte[] bArr, int i12, int i13, zzgj zzgj) throws zzje {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                return zzl(bArr, i12, zzgj);
            }
            if (i14 == 1) {
                return i12 + 8;
            }
            if (i14 == 2) {
                return zzi(bArr, i12, zzgj) + zzgj.zza;
            }
            if (i14 == 3) {
                int i15 = (i11 & -8) | 4;
                int i16 = 0;
                while (i12 < i13) {
                    i12 = zzi(bArr, i12, zzgj);
                    i16 = zzgj.zza;
                    if (i16 == i15) {
                        break;
                    }
                    i12 = zzo(i16, bArr, i12, i13, zzgj);
                }
                if (i12 <= i13 && i16 == i15) {
                    return i12;
                }
                throw zzje.zzg();
            } else if (i14 == 5) {
                return i12 + 4;
            } else {
                throw zzje.zzc();
            }
        } else {
            throw zzje.zzc();
        }
    }

    public static long zzp(byte[] bArr, int i11) {
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48) | ((((long) bArr[i11 + 7]) & 255) << 56);
    }
}
