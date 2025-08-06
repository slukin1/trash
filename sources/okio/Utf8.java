package okio;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import net.sf.scuba.smartcards.ISO7816;

public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i11) {
        if (i11 >= 0 && i11 < 32) {
            return true;
        }
        return 127 <= i11 && i11 < 160;
    }

    public static final boolean isUtf8Continuation(byte b11) {
        return (b11 & ISO7816.INS_GET_RESPONSE) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i11, int i12, l<? super Integer, Unit> lVar) {
        int i13 = i11 + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i13];
        if (!((b12 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b13 = (b12 ^ 3968) ^ (b11 << 6);
        if (b13 < 128) {
            lVar.invoke(valueOf);
            return 2;
        }
        lVar.invoke(Integer.valueOf(b13));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i11, int i12, l<? super Integer, Unit> lVar) {
        int i13 = i11 + 2;
        boolean z11 = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            lVar.invoke(valueOf);
            int i14 = i11 + 1;
            if (i12 > i14) {
                if ((bArr[i14] & ISO7816.INS_GET_RESPONSE) == 128) {
                    z11 = true;
                }
                return !z11 ? 1 : 2;
            }
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        if (!((b12 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b13 = bArr[i13];
        if (!((b13 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 2;
        }
        byte b14 = ((b13 ^ -123008) ^ (b12 << 6)) ^ (b11 << 12);
        if (b14 < 2048) {
            lVar.invoke(valueOf);
            return 3;
        }
        if (55296 <= b14 && b14 < 57344) {
            z11 = true;
        }
        if (z11) {
            lVar.invoke(valueOf);
            return 3;
        }
        lVar.invoke(Integer.valueOf(b14));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i11, int i12, l<? super Integer, Unit> lVar) {
        int i13 = i11 + 3;
        boolean z11 = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            lVar.invoke(valueOf);
            int i14 = i11 + 1;
            if (i12 > i14) {
                if ((bArr[i14] & ISO7816.INS_GET_RESPONSE) == 128) {
                    int i15 = i11 + 2;
                    if (i12 > i15) {
                        if ((bArr[i15] & ISO7816.INS_GET_RESPONSE) == 128) {
                            z11 = true;
                        }
                        return !z11 ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        if (!((b12 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 1;
        }
        byte b13 = bArr[i11 + 2];
        if (!((b13 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 2;
        }
        byte b14 = bArr[i13];
        if (!((b14 & ISO7816.INS_GET_RESPONSE) == 128)) {
            lVar.invoke(valueOf);
            return 3;
        }
        byte b15 = (((b14 ^ 3678080) ^ (b13 << 6)) ^ (b12 << 12)) ^ (b11 << 18);
        if (b15 > 1114111) {
            lVar.invoke(valueOf);
            return 4;
        }
        if (55296 <= b15 && b15 < 57344) {
            z11 = true;
        }
        if (z11) {
            lVar.invoke(valueOf);
            return 4;
        } else if (b15 < 65536) {
            lVar.invoke(valueOf);
            return 4;
        } else {
            lVar.invoke(Integer.valueOf(b15));
            return 4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r8 == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0111, code lost:
        if (r8 == false) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, d10.l<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r18
            r1 = r19
            r2 = r17
        L_0x0006:
            if (r2 >= r0) goto L_0x01b2
            byte r3 = r16[r2]
            if (r3 < 0) goto L_0x002a
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            int r2 = r2 + 1
        L_0x0016:
            if (r2 >= r0) goto L_0x0006
            byte r3 = r16[r2]
            if (r3 < 0) goto L_0x0006
            int r3 = r2 + 1
            byte r2 = r16[r2]
            char r2 = (char) r2
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r1.invoke(r2)
            r2 = r3
            goto L_0x0016
        L_0x002a:
            int r4 = r3 >> 5
            r5 = -2
            r6 = 2
            r7 = 128(0x80, float:1.794E-43)
            r8 = 0
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 1
            if (r4 != r5) goto L_0x0068
            int r3 = r2 + 1
            if (r0 > r3) goto L_0x0047
        L_0x003b:
            char r3 = (char) r9
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x0045:
            r6 = r10
            goto L_0x0066
        L_0x0047:
            byte r4 = r16[r2]
            byte r3 = r16[r3]
            r5 = r3 & 192(0xc0, float:2.69E-43)
            if (r5 != r7) goto L_0x0050
            r8 = r10
        L_0x0050:
            if (r8 != 0) goto L_0x0053
            goto L_0x003b
        L_0x0053:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r3 = r3 ^ r4
            if (r3 >= r7) goto L_0x005c
            char r3 = (char) r9
            goto L_0x005d
        L_0x005c:
            char r3 = (char) r3
        L_0x005d:
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x0066:
            int r2 = r2 + r6
            goto L_0x0006
        L_0x0068:
            int r4 = r3 >> 4
            r11 = 57344(0xe000, float:8.0356E-41)
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 3
            if (r4 != r5) goto L_0x00e4
            int r3 = r2 + 2
            if (r0 > r3) goto L_0x008f
            char r3 = (char) r9
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r3 = r2 + 1
            if (r0 <= r3) goto L_0x0045
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x008c
            r8 = r10
        L_0x008c:
            if (r8 != 0) goto L_0x0066
        L_0x008e:
            goto L_0x0045
        L_0x008f:
            byte r4 = r16[r2]
            int r5 = r2 + 1
            byte r5 = r16[r5]
            r14 = r5 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x009b
            r14 = r10
            goto L_0x009c
        L_0x009b:
            r14 = r8
        L_0x009c:
            if (r14 != 0) goto L_0x00a9
            char r3 = (char) r9
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x008e
        L_0x00a9:
            byte r3 = r16[r3]
            r14 = r3 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x00b1
            r7 = r10
            goto L_0x00b2
        L_0x00b1:
            r7 = r8
        L_0x00b2:
            if (r7 != 0) goto L_0x00bf
            char r3 = (char) r9
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0066
        L_0x00bf:
            r6 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r6
            int r5 = r5 << 6
            r3 = r3 ^ r5
            int r4 = r4 << 12
            r3 = r3 ^ r4
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L_0x00d8
        L_0x00cd:
            char r3 = (char) r9
        L_0x00ce:
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x00e2
        L_0x00d8:
            if (r12 > r3) goto L_0x00dd
            if (r3 >= r11) goto L_0x00dd
            r8 = r10
        L_0x00dd:
            if (r8 == 0) goto L_0x00e0
            goto L_0x00cd
        L_0x00e0:
            char r3 = (char) r3
            goto L_0x00ce
        L_0x00e2:
            r6 = r13
            goto L_0x0066
        L_0x00e4:
            int r3 = r3 >> 3
            if (r3 != r5) goto L_0x01a7
            int r3 = r2 + 3
            if (r0 > r3) goto L_0x0115
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r3 = r2 + 1
            if (r0 <= r3) goto L_0x0045
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x0101
            r3 = r10
            goto L_0x0102
        L_0x0101:
            r3 = r8
        L_0x0102:
            if (r3 != 0) goto L_0x0106
            goto L_0x0045
        L_0x0106:
            int r3 = r2 + 2
            if (r0 <= r3) goto L_0x0066
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x0111
            r8 = r10
        L_0x0111:
            if (r8 != 0) goto L_0x00e2
            goto L_0x0066
        L_0x0115:
            byte r4 = r16[r2]
            int r5 = r2 + 1
            byte r5 = r16[r5]
            r14 = r5 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x0121
            r14 = r10
            goto L_0x0122
        L_0x0121:
            r14 = r8
        L_0x0122:
            if (r14 != 0) goto L_0x012f
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0045
        L_0x012f:
            int r14 = r2 + 2
            byte r14 = r16[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r7) goto L_0x0139
            r15 = r10
            goto L_0x013a
        L_0x0139:
            r15 = r8
        L_0x013a:
            if (r15 != 0) goto L_0x0147
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0066
        L_0x0147:
            byte r3 = r16[r3]
            r6 = r3 & 192(0xc0, float:2.69E-43)
            if (r6 != r7) goto L_0x014f
            r6 = r10
            goto L_0x0150
        L_0x014f:
            r6 = r8
        L_0x0150:
            if (r6 != 0) goto L_0x015c
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x00e2
        L_0x015c:
            r6 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r6
            int r6 = r14 << 6
            r3 = r3 ^ r6
            int r5 = r5 << 12
            r3 = r3 ^ r5
            int r4 = r4 << 18
            r3 = r3 ^ r4
            r4 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r4) goto L_0x0178
        L_0x016e:
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
        L_0x0175:
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x01a4
        L_0x0178:
            if (r12 > r3) goto L_0x017d
            if (r3 >= r11) goto L_0x017d
            r8 = r10
        L_0x017d:
            if (r8 == 0) goto L_0x0180
            goto L_0x016e
        L_0x0180:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r4) goto L_0x0185
            goto L_0x016e
        L_0x0185:
            if (r3 == r9) goto L_0x016e
            int r4 = r3 >>> 10
            r5 = 55232(0xd7c0, float:7.7397E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r1.invoke(r4)
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r4 = 56320(0xdc00, float:7.8921E-41)
            int r3 = r3 + r4
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r1.invoke(r3)
            goto L_0x0175
        L_0x01a4:
            r6 = 4
            goto L_0x0066
        L_0x01a7:
            java.lang.Character r3 = java.lang.Character.valueOf(r9)
            r1.invoke(r3)
            int r2 = r2 + 1
            goto L_0x0006
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, d10.l):void");
    }

    public static final void processUtf8Bytes(String str, int i11, int i12, l<? super Byte, Unit> lVar) {
        int i13;
        while (i11 < i12) {
            char charAt = str.charAt(i11);
            if (x.c(charAt, 128) < 0) {
                lVar.invoke(Byte.valueOf((byte) charAt));
                i11++;
                while (i11 < i12 && x.c(str.charAt(i11), 128) < 0) {
                    lVar.invoke(Byte.valueOf((byte) str.charAt(i11)));
                    i11++;
                }
            } else {
                if (x.c(charAt, 2048) < 0) {
                    lVar.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    lVar.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    boolean z11 = false;
                    if (!(55296 <= charAt && charAt < 57344)) {
                        lVar.invoke(Byte.valueOf((byte) ((charAt >> 12) | 224)));
                        lVar.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                        lVar.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                    } else {
                        if (x.c(charAt, 56319) <= 0 && i12 > (i13 = i11 + 1)) {
                            char charAt2 = str.charAt(i13);
                            if (56320 <= charAt2 && charAt2 < 57344) {
                                z11 = true;
                            }
                            if (z11) {
                                int charAt3 = ((charAt << 10) + str.charAt(i13)) - 56613888;
                                lVar.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                lVar.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                lVar.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                lVar.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i11 += 2;
                            }
                        }
                        lVar.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                }
                i11++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        if (r8 == false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x010f, code lost:
        if (r8 == false) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, d10.l<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r18
            r1 = r19
            r2 = r17
        L_0x0006:
            if (r2 >= r0) goto L_0x0196
            byte r3 = r16[r2]
            if (r3 < 0) goto L_0x0028
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.invoke(r3)
            int r2 = r2 + 1
        L_0x0015:
            if (r2 >= r0) goto L_0x0006
            byte r3 = r16[r2]
            if (r3 < 0) goto L_0x0006
            int r3 = r2 + 1
            byte r2 = r16[r2]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.invoke(r2)
            r2 = r3
            goto L_0x0015
        L_0x0028:
            int r4 = r3 >> 5
            r5 = -2
            r6 = 2
            r7 = 128(0x80, float:1.794E-43)
            r8 = 0
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 1
            if (r4 != r5) goto L_0x0067
            int r3 = r2 + 1
            if (r0 > r3) goto L_0x0044
        L_0x0039:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x0042:
            r6 = r10
            goto L_0x0065
        L_0x0044:
            byte r4 = r16[r2]
            byte r3 = r16[r3]
            r5 = r3 & 192(0xc0, float:2.69E-43)
            if (r5 != r7) goto L_0x004d
            r8 = r10
        L_0x004d:
            if (r8 != 0) goto L_0x0050
            goto L_0x0039
        L_0x0050:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r3 = r3 ^ r4
            if (r3 >= r7) goto L_0x005c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            goto L_0x0060
        L_0x005c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0060:
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
        L_0x0065:
            int r2 = r2 + r6
            goto L_0x0006
        L_0x0067:
            int r4 = r3 >> 4
            r11 = 57344(0xe000, float:8.0356E-41)
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 3
            if (r4 != r5) goto L_0x00e2
            int r3 = r2 + 2
            if (r0 > r3) goto L_0x008d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r3 = r2 + 1
            if (r0 <= r3) goto L_0x0042
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x008a
            r8 = r10
        L_0x008a:
            if (r8 != 0) goto L_0x0065
        L_0x008c:
            goto L_0x0042
        L_0x008d:
            byte r4 = r16[r2]
            int r5 = r2 + 1
            byte r5 = r16[r5]
            r14 = r5 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x0099
            r14 = r10
            goto L_0x009a
        L_0x0099:
            r14 = r8
        L_0x009a:
            if (r14 != 0) goto L_0x00a6
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x008c
        L_0x00a6:
            byte r3 = r16[r3]
            r14 = r3 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x00ae
            r7 = r10
            goto L_0x00af
        L_0x00ae:
            r7 = r8
        L_0x00af:
            if (r7 != 0) goto L_0x00bb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0065
        L_0x00bb:
            r6 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r6
            int r5 = r5 << 6
            r3 = r3 ^ r5
            int r4 = r4 << 12
            r3 = r3 ^ r4
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L_0x00d3
        L_0x00c9:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
        L_0x00cd:
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x00e0
        L_0x00d3:
            if (r12 > r3) goto L_0x00d8
            if (r3 >= r11) goto L_0x00d8
            r8 = r10
        L_0x00d8:
            if (r8 == 0) goto L_0x00db
            goto L_0x00c9
        L_0x00db:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00cd
        L_0x00e0:
            r6 = r13
            goto L_0x0065
        L_0x00e2:
            int r3 = r3 >> 3
            if (r3 != r5) goto L_0x018b
            int r3 = r2 + 3
            if (r0 > r3) goto L_0x0113
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r3 = r2 + 1
            if (r0 <= r3) goto L_0x0042
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x00ff
            r3 = r10
            goto L_0x0100
        L_0x00ff:
            r3 = r8
        L_0x0100:
            if (r3 != 0) goto L_0x0104
            goto L_0x0042
        L_0x0104:
            int r3 = r2 + 2
            if (r0 <= r3) goto L_0x0065
            byte r3 = r16[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r7) goto L_0x010f
            r8 = r10
        L_0x010f:
            if (r8 != 0) goto L_0x00e0
            goto L_0x0065
        L_0x0113:
            byte r4 = r16[r2]
            int r5 = r2 + 1
            byte r5 = r16[r5]
            r14 = r5 & 192(0xc0, float:2.69E-43)
            if (r14 != r7) goto L_0x011f
            r14 = r10
            goto L_0x0120
        L_0x011f:
            r14 = r8
        L_0x0120:
            if (r14 != 0) goto L_0x012d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0042
        L_0x012d:
            int r14 = r2 + 2
            byte r14 = r16[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r7) goto L_0x0137
            r15 = r10
            goto L_0x0138
        L_0x0137:
            r15 = r8
        L_0x0138:
            if (r15 != 0) goto L_0x0145
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0065
        L_0x0145:
            byte r3 = r16[r3]
            r6 = r3 & 192(0xc0, float:2.69E-43)
            if (r6 != r7) goto L_0x014d
            r6 = r10
            goto L_0x014e
        L_0x014d:
            r6 = r8
        L_0x014e:
            if (r6 != 0) goto L_0x015a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x00e0
        L_0x015a:
            r6 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r6
            int r6 = r14 << 6
            r3 = r3 ^ r6
            int r5 = r5 << 12
            r3 = r3 ^ r5
            int r4 = r4 << 18
            r3 = r3 ^ r4
            r4 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r4) goto L_0x0176
        L_0x016c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
        L_0x0170:
            r1.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f56620a
            goto L_0x0188
        L_0x0176:
            if (r12 > r3) goto L_0x017b
            if (r3 >= r11) goto L_0x017b
            r8 = r10
        L_0x017b:
            if (r8 == 0) goto L_0x017e
            goto L_0x016c
        L_0x017e:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r4) goto L_0x0183
            goto L_0x016c
        L_0x0183:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0170
        L_0x0188:
            r6 = 4
            goto L_0x0065
        L_0x018b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r1.invoke(r3)
            int r2 = r2 + 1
            goto L_0x0006
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, d10.l):void");
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, (Object) null);
    }

    public static final long size(String str, int i11) {
        return size$default(str, i11, 0, 2, (Object) null);
    }

    public static final long size(String str, int i11, int i12) {
        int i13;
        boolean z11 = true;
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 > str.length()) {
                    z11 = false;
                }
                if (z11) {
                    long j11 = 0;
                    while (i11 < i12) {
                        char charAt = str.charAt(i11);
                        if (charAt < 128) {
                            j11++;
                        } else {
                            if (charAt < 2048) {
                                i13 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i13 = 3;
                            } else {
                                int i14 = i11 + 1;
                                char charAt2 = i14 < i12 ? str.charAt(i14) : 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j11++;
                                    i11 = i14;
                                } else {
                                    j11 += (long) 4;
                                    i11 += 2;
                                }
                            }
                            j11 += (long) i13;
                        }
                        i11++;
                    }
                    return j11;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
    }

    public static /* synthetic */ long size$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return size(str, i11, i12);
    }
}
