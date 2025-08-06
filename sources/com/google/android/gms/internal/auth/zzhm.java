package com.google.android.gms.internal.auth;

final class zzhm {
    private static final zzhk zza = new zzhl();

    static {
        if (zzhi.zzu() && zzhi.zzv()) {
            int i11 = zzdr.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 != 0) {
            if (i13 == 1) {
                byte b12 = bArr[i11];
                if (b11 <= -12 && b12 <= -65) {
                    return b11 ^ (b12 << 8);
                }
            } else if (i13 == 2) {
                byte b13 = bArr[i11];
                byte b14 = bArr[i11 + 1];
                if (b11 <= -12 && b13 <= -65 && b14 <= -65) {
                    return ((b13 << 8) ^ b11) ^ (b14 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b11 <= -12) {
            return b11;
        }
        return -1;
    }

    public static String zzb(byte[] bArr, int i11, int i12) throws zzfa {
        int i13;
        int length = bArr.length;
        if ((i11 | i12 | ((length - i11) - i12)) >= 0) {
            int i14 = i11 + i12;
            char[] cArr = new char[i12];
            int i15 = 0;
            while (r11 < i14) {
                byte b11 = bArr[r11];
                if (!zzhj.zzd(b11)) {
                    break;
                }
                i11 = r11 + 1;
                cArr[i13] = (char) b11;
                i15 = i13 + 1;
            }
            while (r11 < i14) {
                int i16 = r11 + 1;
                byte b12 = bArr[r11];
                if (zzhj.zzd(b12)) {
                    int i17 = i13 + 1;
                    cArr[i13] = (char) b12;
                    r11 = i16;
                    while (true) {
                        i13 = i17;
                        if (r11 >= i14) {
                            break;
                        }
                        byte b13 = bArr[r11];
                        if (!zzhj.zzd(b13)) {
                            break;
                        }
                        r11++;
                        i17 = i13 + 1;
                        cArr[i13] = (char) b13;
                    }
                } else if (b12 < -32) {
                    if (i16 < i14) {
                        zzhj.zzc(b12, bArr[i16], cArr, i13);
                        r11 = i16 + 1;
                        i13++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b12 < -16) {
                    if (i16 < i14 - 1) {
                        int i18 = i16 + 1;
                        zzhj.zzb(b12, bArr[i16], bArr[i18], cArr, i13);
                        r11 = i18 + 1;
                        i13++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i16 < i14 - 2) {
                    int i19 = i16 + 1;
                    int i21 = i19 + 1;
                    zzhj.zza(b12, bArr[i16], bArr[i19], bArr[i21], cArr, i13);
                    i13 += 2;
                    r11 = i21 + 1;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i13);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public static boolean zzc(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzd(byte[] bArr, int i11, int i12) {
        return zza.zzb(bArr, i11, i12);
    }
}
