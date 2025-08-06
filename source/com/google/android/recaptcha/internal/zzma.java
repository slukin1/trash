package com.google.android.recaptcha.internal;

final class zzma {
    private static final zzlx zza = new zzly();

    static {
        if (zzlv.zzx() && zzlv.zzy()) {
            int i11 = zzgi.zza;
        }
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int i11, int i12) {
        int i13 = i12 - i11;
        byte b11 = bArr[i11 - 1];
        if (i13 != 0) {
            if (i13 == 1) {
                byte b12 = bArr[i11];
                if (b11 > -12 || b12 > -65) {
                    return -1;
                }
                return (b12 << 8) ^ b11;
            } else if (i13 == 2) {
                byte b13 = bArr[i11];
                byte b14 = bArr[i11 + 1];
                if (b11 > -12 || b13 > -65 || b14 > -65) {
                    return -1;
                }
                return (b14 << 16) ^ ((b13 << 8) ^ b11);
            } else {
                throw new AssertionError();
            }
        } else if (b11 <= -12) {
            return b11;
        } else {
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            int r0 = r8.length()
            r1 = 0
        L_0x0005:
            int r2 = r10 + r11
            r3 = 128(0x80, float:1.794E-43)
            if (r1 >= r0) goto L_0x001b
            int r4 = r1 + r10
            if (r4 >= r2) goto L_0x001b
            char r5 = r8.charAt(r1)
            if (r5 >= r3) goto L_0x001b
            byte r2 = (byte) r5
            r9[r4] = r2
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001b:
            if (r1 != r0) goto L_0x0020
            int r10 = r10 + r0
            goto L_0x0101
        L_0x0020:
            int r10 = r10 + r1
        L_0x0021:
            if (r1 >= r0) goto L_0x0101
            char r11 = r8.charAt(r1)
            if (r11 >= r3) goto L_0x0033
            if (r10 >= r2) goto L_0x0033
            int r4 = r10 + 1
            byte r11 = (byte) r11
            r9[r10] = r11
            r10 = r4
            goto L_0x00b9
        L_0x0033:
            r4 = 2048(0x800, float:2.87E-42)
            if (r11 >= r4) goto L_0x004e
            int r4 = r2 + -2
            if (r10 > r4) goto L_0x004e
            int r4 = r10 + 1
            int r5 = r4 + 1
            int r6 = r11 >>> 6
            r6 = r6 | 960(0x3c0, float:1.345E-42)
            byte r6 = (byte) r6
            r9[r10] = r6
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r5
            goto L_0x00b9
        L_0x004e:
            r4 = 57343(0xdfff, float:8.0355E-41)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r11 < r5) goto L_0x0058
            if (r11 <= r4) goto L_0x0079
        L_0x0058:
            int r6 = r2 + -3
            if (r10 > r6) goto L_0x0079
            int r4 = r10 + 1
            int r5 = r4 + 1
            int r6 = r5 + 1
            int r7 = r11 >>> 12
            r7 = r7 | 480(0x1e0, float:6.73E-43)
            byte r7 = (byte) r7
            r9[r10] = r7
            int r10 = r11 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r4] = r10
            r10 = r11 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r5] = r10
            r10 = r6
            goto L_0x00b9
        L_0x0079:
            int r6 = r2 + -4
            if (r10 > r6) goto L_0x00c6
            int r4 = r1 + 1
            int r5 = r8.length()
            if (r4 == r5) goto L_0x00be
            char r1 = r8.charAt(r4)
            boolean r5 = java.lang.Character.isSurrogatePair(r11, r1)
            if (r5 == 0) goto L_0x00bd
            int r5 = r10 + 1
            int r6 = r5 + 1
            int r7 = r6 + 1
            int r11 = java.lang.Character.toCodePoint(r11, r1)
            int r1 = r11 >>> 18
            r1 = r1 | 240(0xf0, float:3.36E-43)
            byte r1 = (byte) r1
            r9[r10] = r1
            int r10 = r11 >>> 12
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r5] = r10
            int r10 = r11 >>> 6
            r10 = r10 & 63
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r6] = r10
            int r10 = r7 + 1
            r11 = r11 & 63
            r11 = r11 | r3
            byte r11 = (byte) r11
            r9[r7] = r11
            r1 = r4
        L_0x00b9:
            int r1 = r1 + 1
            goto L_0x0021
        L_0x00bd:
            r1 = r4
        L_0x00be:
            com.google.android.recaptcha.internal.zzlz r8 = new com.google.android.recaptcha.internal.zzlz
            int r1 = r1 + -1
            r8.<init>(r1, r0)
            throw r8
        L_0x00c6:
            if (r11 < r5) goto L_0x00e2
            if (r11 > r4) goto L_0x00e2
            int r9 = r1 + 1
            int r2 = r8.length()
            if (r9 == r2) goto L_0x00dc
            char r8 = r8.charAt(r9)
            boolean r8 = java.lang.Character.isSurrogatePair(r11, r8)
            if (r8 != 0) goto L_0x00e2
        L_0x00dc:
            com.google.android.recaptcha.internal.zzlz r8 = new com.google.android.recaptcha.internal.zzlz
            r8.<init>(r1, r0)
            throw r8
        L_0x00e2:
            java.lang.ArrayIndexOutOfBoundsException r8 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Failed writing "
            r9.append(r0)
            r9.append(r11)
            java.lang.String r11 = " at index "
            r9.append(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0101:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzma.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < length && charSequence.charAt(i12) < 128) {
            i12++;
        }
        int i13 = length;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt < 2048) {
                i13 += (127 - charAt) >>> 31;
                i12++;
            } else {
                int length2 = charSequence.length();
                while (i12 < length2) {
                    char charAt2 = charSequence.charAt(i12);
                    if (charAt2 < 2048) {
                        i11 += (127 - charAt2) >>> 31;
                    } else {
                        i11 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i12) >= 65536) {
                                i12++;
                            } else {
                                throw new zzlz(i12, length2);
                            }
                        }
                    }
                    i12++;
                }
                i13 += i11;
            }
        }
        if (i13 >= length) {
            return i13;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i13) + 4294967296L));
    }

    public static String zzd(byte[] bArr, int i11, int i12) throws zzje {
        int i13;
        int length = bArr.length;
        if ((((length - i11) - i12) | i11 | i12) >= 0) {
            int i14 = i11 + i12;
            char[] cArr = new char[i12];
            int i15 = 0;
            while (r11 < i14) {
                byte b11 = bArr[r11];
                if (!zzlw.zzd(b11)) {
                    break;
                }
                i11 = r11 + 1;
                cArr[i13] = (char) b11;
                i15 = i13 + 1;
            }
            while (r11 < i14) {
                int i16 = r11 + 1;
                byte b12 = bArr[r11];
                if (zzlw.zzd(b12)) {
                    int i17 = i13 + 1;
                    cArr[i13] = (char) b12;
                    r11 = i16;
                    while (true) {
                        i13 = i17;
                        if (r11 >= i14) {
                            break;
                        }
                        byte b13 = bArr[r11];
                        if (!zzlw.zzd(b13)) {
                            break;
                        }
                        r11++;
                        i17 = i13 + 1;
                        cArr[i13] = (char) b13;
                    }
                } else if (b12 < -32) {
                    if (i16 < i14) {
                        zzlw.zzc(b12, bArr[i16], cArr, i13);
                        i13++;
                        r11 = i16 + 1;
                    } else {
                        throw zzje.zzd();
                    }
                } else if (b12 < -16) {
                    if (i16 < i14 - 1) {
                        int i18 = i16 + 1;
                        zzlw.zzb(b12, bArr[i16], bArr[i18], cArr, i13);
                        i13++;
                        r11 = i18 + 1;
                    } else {
                        throw zzje.zzd();
                    }
                } else if (i16 < i14 - 2) {
                    int i19 = i16 + 1;
                    byte b14 = bArr[i16];
                    int i21 = i19 + 1;
                    zzlw.zza(b12, b14, bArr[i19], bArr[i21], cArr, i13);
                    i13 += 2;
                    r11 = i21 + 1;
                } else {
                    throw zzje.zzd();
                }
            }
            return new String(cArr, 0, i13);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    public static boolean zze(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i11, int i12) {
        return zza.zzb(bArr, i11, i12);
    }
}
