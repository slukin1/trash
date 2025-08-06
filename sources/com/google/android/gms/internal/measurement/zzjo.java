package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

final class zzjo {
    public static int zza(byte[] bArr, int i11, zzjn zzjn) throws zzll {
        int zzj = zzj(bArr, i11, zzjn);
        int i12 = zzjn.zza;
        if (i12 < 0) {
            throw zzll.zzd();
        } else if (i12 > bArr.length - zzj) {
            throw zzll.zzf();
        } else if (i12 == 0) {
            zzjn.zzc = zzka.zzb;
            return zzj;
        } else {
            zzjn.zzc = zzka.zzl(bArr, zzj, i12);
            return zzj + i12;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static int zzc(zzmt zzmt, byte[] bArr, int i11, int i12, int i13, zzjn zzjn) throws IOException {
        Object zze = zzmt.zze();
        int zzn = zzn(zze, zzmt, bArr, i11, i12, i13, zzjn);
        zzmt.zzf(zze);
        zzjn.zzc = zze;
        return zzn;
    }

    public static int zzd(zzmt zzmt, byte[] bArr, int i11, int i12, zzjn zzjn) throws IOException {
        Object zze = zzmt.zze();
        int zzo = zzo(zze, zzmt, bArr, i11, i12, zzjn);
        zzmt.zzf(zze);
        zzjn.zzc = zze;
        return zzo;
    }

    public static int zze(zzmt zzmt, int i11, byte[] bArr, int i12, int i13, zzli zzli, zzjn zzjn) throws IOException {
        int zzd = zzd(zzmt, bArr, i12, i13, zzjn);
        zzli.add(zzjn.zzc);
        while (zzd < i13) {
            int zzj = zzj(bArr, zzd, zzjn);
            if (i11 != zzjn.zza) {
                break;
            }
            zzd = zzd(zzmt, bArr, zzj, i13, zzjn);
            zzli.add(zzjn.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i11, zzli zzli, zzjn zzjn) throws IOException {
        zzlc zzlc = (zzlc) zzli;
        int zzj = zzj(bArr, i11, zzjn);
        int i12 = zzjn.zza + zzj;
        while (zzj < i12) {
            zzj = zzj(bArr, zzj, zzjn);
            zzlc.zzh(zzjn.zza);
        }
        if (zzj == i12) {
            return zzj;
        }
        throw zzll.zzf();
    }

    public static int zzg(byte[] bArr, int i11, zzjn zzjn) throws zzll {
        int zzj = zzj(bArr, i11, zzjn);
        int i12 = zzjn.zza;
        if (i12 < 0) {
            throw zzll.zzd();
        } else if (i12 == 0) {
            zzjn.zzc = "";
            return zzj;
        } else {
            zzjn.zzc = new String(bArr, zzj, i12, zzlj.zzb);
            return zzj + i12;
        }
    }

    public static int zzh(byte[] bArr, int i11, zzjn zzjn) throws zzll {
        int i12;
        int i13;
        int zzj = zzj(bArr, i11, zzjn);
        int i14 = zzjn.zza;
        if (i14 < 0) {
            throw zzll.zzd();
        } else if (i14 == 0) {
            zzjn.zzc = "";
            return zzj;
        } else {
            int i15 = zznz.zza;
            int length = bArr.length;
            if ((((length - zzj) - i14) | zzj | i14) >= 0) {
                int i16 = zzj + i14;
                char[] cArr = new char[i14];
                int i17 = 0;
                while (i12 < i16) {
                    byte b11 = bArr[i12];
                    if (!zznv.zzd(b11)) {
                        break;
                    }
                    zzj = i12 + 1;
                    cArr[i13] = (char) b11;
                    i17 = i13 + 1;
                }
                while (i12 < i16) {
                    int i18 = i12 + 1;
                    byte b12 = bArr[i12];
                    if (zznv.zzd(b12)) {
                        int i19 = i13 + 1;
                        cArr[i13] = (char) b12;
                        i12 = i18;
                        while (true) {
                            i13 = i19;
                            if (i12 >= i16) {
                                break;
                            }
                            byte b13 = bArr[i12];
                            if (!zznv.zzd(b13)) {
                                break;
                            }
                            i12++;
                            i19 = i13 + 1;
                            cArr[i13] = (char) b13;
                        }
                    } else if (b12 < -32) {
                        if (i18 < i16) {
                            zznv.zzc(b12, bArr[i18], cArr, i13);
                            i12 = i18 + 1;
                            i13++;
                        } else {
                            throw zzll.zzc();
                        }
                    } else if (b12 < -16) {
                        if (i18 < i16 - 1) {
                            int i21 = i18 + 1;
                            zznv.zzb(b12, bArr[i18], bArr[i21], cArr, i13);
                            i12 = i21 + 1;
                            i13++;
                        } else {
                            throw zzll.zzc();
                        }
                    } else if (i18 < i16 - 2) {
                        int i22 = i18 + 1;
                        byte b14 = bArr[i18];
                        int i23 = i22 + 1;
                        zznv.zza(b12, b14, bArr[i22], bArr[i23], cArr, i13);
                        i13 += 2;
                        i12 = i23 + 1;
                    } else {
                        throw zzll.zzc();
                    }
                }
                zzjn.zzc = new String(cArr, 0, i13);
                return i16;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(zzj), Integer.valueOf(i14)}));
        }
    }

    public static int zzi(int i11, byte[] bArr, int i12, int i13, zznl zznl, zzjn zzjn) throws zzll {
        if ((i11 >>> 3) != 0) {
            int i14 = i11 & 7;
            if (i14 == 0) {
                int zzm = zzm(bArr, i12, zzjn);
                zznl.zzj(i11, Long.valueOf(zzjn.zzb));
                return zzm;
            } else if (i14 == 1) {
                zznl.zzj(i11, Long.valueOf(zzp(bArr, i12)));
                return i12 + 8;
            } else if (i14 == 2) {
                int zzj = zzj(bArr, i12, zzjn);
                int i15 = zzjn.zza;
                if (i15 < 0) {
                    throw zzll.zzd();
                } else if (i15 <= bArr.length - zzj) {
                    if (i15 == 0) {
                        zznl.zzj(i11, zzka.zzb);
                    } else {
                        zznl.zzj(i11, zzka.zzl(bArr, zzj, i15));
                    }
                    return zzj + i15;
                } else {
                    throw zzll.zzf();
                }
            } else if (i14 == 3) {
                int i16 = (i11 & -8) | 4;
                zznl zzf = zznl.zzf();
                int i17 = 0;
                while (true) {
                    if (i12 >= i13) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i12, zzjn);
                    int i18 = zzjn.zza;
                    i17 = i18;
                    if (i18 == i16) {
                        i12 = zzj2;
                        break;
                    }
                    int zzi = zzi(i17, bArr, zzj2, i13, zzf, zzjn);
                    i17 = i18;
                    i12 = zzi;
                }
                if (i12 > i13 || i17 != i16) {
                    throw zzll.zze();
                }
                zznl.zzj(i11, zzf);
                return i12;
            } else if (i14 == 5) {
                zznl.zzj(i11, Integer.valueOf(zzb(bArr, i12)));
                return i12 + 4;
            } else {
                throw zzll.zzb();
            }
        } else {
            throw zzll.zzb();
        }
    }

    public static int zzj(byte[] bArr, int i11, zzjn zzjn) {
        int i12 = i11 + 1;
        byte b11 = bArr[i11];
        if (b11 < 0) {
            return zzk(b11, bArr, i12, zzjn);
        }
        zzjn.zza = b11;
        return i12;
    }

    public static int zzk(int i11, byte[] bArr, int i12, zzjn zzjn) {
        byte b11 = bArr[i12];
        int i13 = i12 + 1;
        int i14 = i11 & 127;
        if (b11 >= 0) {
            zzjn.zza = i14 | (b11 << 7);
            return i13;
        }
        int i15 = i14 | ((b11 & Ascii.DEL) << 7);
        int i16 = i13 + 1;
        byte b12 = bArr[i13];
        if (b12 >= 0) {
            zzjn.zza = i15 | (b12 << 14);
            return i16;
        }
        int i17 = i15 | ((b12 & Ascii.DEL) << 14);
        int i18 = i16 + 1;
        byte b13 = bArr[i16];
        if (b13 >= 0) {
            zzjn.zza = i17 | (b13 << 21);
            return i18;
        }
        int i19 = i17 | ((b13 & Ascii.DEL) << 21);
        int i21 = i18 + 1;
        byte b14 = bArr[i18];
        if (b14 >= 0) {
            zzjn.zza = i19 | (b14 << 28);
            return i21;
        }
        int i22 = i19 | ((b14 & Ascii.DEL) << 28);
        while (true) {
            int i23 = i21 + 1;
            if (bArr[i21] < 0) {
                i21 = i23;
            } else {
                zzjn.zza = i22;
                return i23;
            }
        }
    }

    public static int zzl(int i11, byte[] bArr, int i12, int i13, zzli zzli, zzjn zzjn) {
        zzlc zzlc = (zzlc) zzli;
        int zzj = zzj(bArr, i12, zzjn);
        zzlc.zzh(zzjn.zza);
        while (zzj < i13) {
            int zzj2 = zzj(bArr, zzj, zzjn);
            if (i11 != zzjn.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzjn);
            zzlc.zzh(zzjn.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i11, zzjn zzjn) {
        long j11 = (long) bArr[i11];
        int i12 = i11 + 1;
        if (j11 >= 0) {
            zzjn.zzb = j11;
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
        zzjn.zzb = j12;
        return i13;
    }

    public static int zzn(Object obj, zzmt zzmt, byte[] bArr, int i11, int i12, int i13, zzjn zzjn) throws IOException {
        int zzc = ((zzml) zzmt).zzc(obj, bArr, i11, i12, i13, zzjn);
        zzjn.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzo(java.lang.Object r6, com.google.android.gms.internal.measurement.zzmt r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzjn r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
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
            r0.zzh(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.measurement.zzll r6 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjo.zzo(java.lang.Object, com.google.android.gms.internal.measurement.zzmt, byte[], int, int, com.google.android.gms.internal.measurement.zzjn):int");
    }

    public static long zzp(byte[] bArr, int i11) {
        return (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48) | ((((long) bArr[i11 + 7]) & 255) << 56);
    }
}
