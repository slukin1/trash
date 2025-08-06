package okio.internal;

import java.util.Arrays;
import kotlin.jvm.internal.x;
import okio.Utf8;

public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i15 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (x.c(charAt, 128) >= 0) {
                int length2 = str.length();
                int i16 = i11;
                while (i11 < length2) {
                    char charAt2 = str.charAt(i11);
                    if (x.c(charAt2, 128) < 0) {
                        int i17 = i16 + 1;
                        bArr[i16] = (byte) charAt2;
                        i11++;
                        while (true) {
                            i16 = i17;
                            if (i11 >= length2 || x.c(str.charAt(i11), 128) >= 0) {
                                break;
                            }
                            i17 = i16 + 1;
                            bArr[i16] = (byte) str.charAt(i11);
                            i11++;
                        }
                    } else {
                        if (x.c(charAt2, 2048) < 0) {
                            int i18 = i16 + 1;
                            bArr[i16] = (byte) ((charAt2 >> 6) | 192);
                            i12 = i18 + 1;
                            bArr[i18] = (byte) ((charAt2 & '?') | 128);
                        } else {
                            boolean z11 = true;
                            if (!(55296 <= charAt2 && charAt2 < 57344)) {
                                int i19 = i16 + 1;
                                bArr[i16] = (byte) ((charAt2 >> 12) | 224);
                                int i21 = i19 + 1;
                                bArr[i19] = (byte) (((charAt2 >> 6) & 63) | 128);
                                i12 = i21 + 1;
                                bArr[i21] = (byte) ((charAt2 & '?') | 128);
                            } else {
                                if (x.c(charAt2, 56319) <= 0 && length2 > (i13 = i11 + 1)) {
                                    char charAt3 = str.charAt(i13);
                                    if (56320 > charAt3 || charAt3 >= 57344) {
                                        z11 = false;
                                    }
                                    if (z11) {
                                        int charAt4 = ((charAt2 << 10) + str.charAt(i13)) - 56613888;
                                        int i22 = i16 + 1;
                                        bArr[i16] = (byte) ((charAt4 >> 18) | 240);
                                        int i23 = i22 + 1;
                                        bArr[i22] = (byte) (((charAt4 >> 12) & 63) | 128);
                                        int i24 = i23 + 1;
                                        bArr[i23] = (byte) (((charAt4 >> 6) & 63) | 128);
                                        i12 = i24 + 1;
                                        bArr[i24] = (byte) ((charAt4 & 63) | 128);
                                        i14 = i11 + 2;
                                        i16 = i12;
                                    }
                                }
                                i12 = i16 + 1;
                                bArr[i16] = Utf8.REPLACEMENT_BYTE;
                            }
                        }
                        i14 = i11 + 1;
                        i16 = i12;
                    }
                }
                return Arrays.copyOf(bArr, i16);
            }
            bArr[i11] = (byte) charAt;
            i15 = i11 + 1;
        }
        return Arrays.copyOf(bArr, str.length());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0098, code lost:
        if (((r0[r5] & net.sf.scuba.smartcards.ISO7816.INS_GET_RESPONSE) == 128) == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x011e, code lost:
        if (((r0[r5] & net.sf.scuba.smartcards.ISO7816.INS_GET_RESPONSE) == 128) == false) goto L_0x0123;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            if (r1 < 0) goto L_0x01c5
            int r3 = r0.length
            if (r2 > r3) goto L_0x01c5
            if (r1 > r2) goto L_0x01c5
            int r3 = r2 - r1
            char[] r3 = new char[r3]
            r4 = 0
            r5 = r4
        L_0x0013:
            if (r1 >= r2) goto L_0x01c0
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0032
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            int r1 = r1 + 1
        L_0x0020:
            r5 = r7
            if (r1 >= r2) goto L_0x0013
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0013
            int r6 = r1 + 1
            byte r1 = r0[r1]
            char r1 = (char) r1
            int r7 = r5 + 1
            r3[r5] = r1
            r1 = r6
            goto L_0x0020
        L_0x0032:
            int r7 = r6 >> 5
            r8 = -2
            r10 = 128(0x80, float:1.794E-43)
            r11 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r8) goto L_0x0075
            int r6 = r1 + 1
            if (r2 > r6) goto L_0x004a
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.f56620a
        L_0x0047:
            r5 = r7
        L_0x0048:
            r9 = 1
            goto L_0x0073
        L_0x004a:
            byte r7 = r0[r1]
            byte r6 = r0[r6]
            r8 = r6 & 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x0054
            r8 = 1
            goto L_0x0055
        L_0x0054:
            r8 = r4
        L_0x0055:
            if (r8 != 0) goto L_0x005d
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0045
        L_0x005d:
            r6 = r6 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r6 = r6 ^ r7
            if (r6 >= r10) goto L_0x006a
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x006f
        L_0x006a:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x006f:
            kotlin.Unit r5 = kotlin.Unit.f56620a
        L_0x0071:
            r5 = r7
        L_0x0072:
            r9 = 2
        L_0x0073:
            int r1 = r1 + r9
            goto L_0x0013
        L_0x0075:
            int r7 = r6 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            r15 = 3
            if (r7 != r8) goto L_0x00f3
            int r6 = r1 + 2
            if (r2 > r6) goto L_0x009b
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f56620a
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0047
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0097
            r5 = 1
            goto L_0x0098
        L_0x0097:
            r5 = r4
        L_0x0098:
            if (r5 != 0) goto L_0x0071
            goto L_0x0047
        L_0x009b:
            byte r7 = r0[r1]
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00a7
            r9 = 1
            goto L_0x00a8
        L_0x00a7:
            r9 = r4
        L_0x00a8:
            if (r9 != 0) goto L_0x00b2
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x0047
        L_0x00b2:
            byte r6 = r0[r6]
            r9 = r6 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00ba
            r9 = 1
            goto L_0x00bb
        L_0x00ba:
            r9 = r4
        L_0x00bb:
            if (r9 != 0) goto L_0x00c5
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x0071
        L_0x00c5:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r6 = r6 ^ r9
            int r8 = r8 << 6
            r6 = r6 ^ r8
            int r7 = r7 << 12
            r6 = r6 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 >= r7) goto L_0x00db
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x00d8:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x00f0
        L_0x00db:
            if (r14 > r6) goto L_0x00e1
            if (r6 >= r13) goto L_0x00e1
            r12 = 1
            goto L_0x00e2
        L_0x00e1:
            r12 = r4
        L_0x00e2:
            if (r12 == 0) goto L_0x00ea
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00d8
        L_0x00ea:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00d8
        L_0x00f0:
            r5 = r7
        L_0x00f1:
            r9 = r15
            goto L_0x0073
        L_0x00f3:
            int r6 = r6 >> 3
            if (r6 != r8) goto L_0x01b7
            int r6 = r1 + 3
            if (r2 > r6) goto L_0x0129
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f56620a
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0126
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x010d
            r5 = 1
            goto L_0x010e
        L_0x010d:
            r5 = r4
        L_0x010e:
            if (r5 != 0) goto L_0x0111
            goto L_0x0126
        L_0x0111:
            int r5 = r1 + 2
            if (r2 <= r5) goto L_0x0123
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x011d
            r12 = 1
            goto L_0x011e
        L_0x011d:
            r12 = r4
        L_0x011e:
            if (r12 != 0) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r5 = r6
            goto L_0x00f1
        L_0x0123:
            r5 = r6
            goto L_0x0072
        L_0x0126:
            r5 = r6
            goto L_0x0048
        L_0x0129:
            byte r7 = r0[r1]
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x0135
            r9 = 1
            goto L_0x0136
        L_0x0135:
            r9 = r4
        L_0x0136:
            if (r9 != 0) goto L_0x013f
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x0126
        L_0x013f:
            int r9 = r1 + 2
            byte r9 = r0[r9]
            r12 = r9 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0149
            r12 = 1
            goto L_0x014a
        L_0x0149:
            r12 = r4
        L_0x014a:
            if (r12 != 0) goto L_0x0153
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x0123
        L_0x0153:
            byte r6 = r0[r6]
            r12 = r6 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x015b
            r10 = 1
            goto L_0x015c
        L_0x015b:
            r10 = r4
        L_0x015c:
            if (r10 != 0) goto L_0x0165
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x0121
        L_0x0165:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r6 = r6 ^ r10
            int r9 = r9 << 6
            r6 = r6 ^ r9
            int r8 = r8 << 12
            r6 = r6 ^ r8
            int r7 = r7 << 18
            r6 = r6 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r7) goto L_0x017e
            int r6 = r5 + 1
            r3[r5] = r11
        L_0x017b:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            goto L_0x01b3
        L_0x017e:
            if (r14 > r6) goto L_0x0184
            if (r6 >= r13) goto L_0x0184
            r12 = 1
            goto L_0x0185
        L_0x0184:
            r12 = r4
        L_0x0185:
            if (r12 == 0) goto L_0x018c
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x017b
        L_0x018c:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x0195
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x017b
        L_0x0195:
            if (r6 == r11) goto L_0x01ae
            int r7 = r6 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r7 = r7 + r8
            char r7 = (char) r7
            int r8 = r5 + 1
            r3[r5] = r7
            r5 = r6 & 1023(0x3ff, float:1.434E-42)
            r6 = 56320(0xdc00, float:7.8921E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            int r6 = r8 + 1
            r3[r8] = r5
            goto L_0x017b
        L_0x01ae:
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x017b
        L_0x01b3:
            r9 = 4
            r5 = r6
            goto L_0x0073
        L_0x01b7:
            int r6 = r5 + 1
            r3[r5] = r11
            int r1 = r1 + 1
            r5 = r6
            goto L_0x0013
        L_0x01c0:
            java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.r(r3, r4, r5)
            return r0
        L_0x01c5:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "size="
            r4.append(r5)
            int r0 = r0.length
            r4.append(r0)
            java.lang.String r0 = " beginIndex="
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " endIndex="
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = bArr.length;
        }
        return commonToUtf8String(bArr, i11, i12);
    }
}
