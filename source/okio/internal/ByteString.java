package okio.internal;

import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;

/* renamed from: okio.internal.-ByteString  reason: invalid class name */
public final class ByteString {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0220 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0047 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0173 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0083 A[EDGE_INSN: B:263:0x0083->B:51:0x0083 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x00df A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x0234
            byte r7 = r0[r4]
            r8 = 160(0xa0, float:2.24E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 32
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x008d
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0045
            if (r7 == r11) goto L_0x0045
            if (r7 < 0) goto L_0x0031
            if (r7 >= r10) goto L_0x0031
            r6 = r17
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            if (r6 != 0) goto L_0x0041
            if (r9 > r7) goto L_0x003b
            if (r7 >= r8) goto L_0x003b
            r6 = r17
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = 0
            goto L_0x0043
        L_0x0041:
            r6 = r17
        L_0x0043:
            if (r6 != 0) goto L_0x0047
        L_0x0045:
            if (r7 != r12) goto L_0x0048
        L_0x0047:
            return r16
        L_0x0048:
            if (r7 >= r14) goto L_0x004d
            r6 = r17
            goto L_0x004e
        L_0x004d:
            r6 = 2
        L_0x004e:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x0051:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r7 = r4 + 1
            byte r4 = r0[r4]
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0062
            return r5
        L_0x0062:
            if (r4 == r13) goto L_0x0081
            if (r4 == r11) goto L_0x0081
            if (r4 < 0) goto L_0x006d
            if (r4 >= r10) goto L_0x006d
            r6 = r17
            goto L_0x006e
        L_0x006d:
            r6 = 0
        L_0x006e:
            if (r6 != 0) goto L_0x007d
            if (r9 > r4) goto L_0x0077
            if (r4 >= r8) goto L_0x0077
            r6 = r17
            goto L_0x0078
        L_0x0077:
            r6 = 0
        L_0x0078:
            if (r6 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r6 = 0
            goto L_0x007f
        L_0x007d:
            r6 = r17
        L_0x007f:
            if (r6 != 0) goto L_0x0083
        L_0x0081:
            if (r4 != r12) goto L_0x0084
        L_0x0083:
            return r16
        L_0x0084:
            if (r4 >= r14) goto L_0x0089
            r4 = r17
            goto L_0x008a
        L_0x0089:
            r4 = 2
        L_0x008a:
            int r5 = r5 + r4
            r4 = r7
            goto L_0x0051
        L_0x008d:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00f0
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x009c
            if (r6 != r1) goto L_0x009b
            return r5
        L_0x009b:
            return r16
        L_0x009c:
            byte r7 = r0[r4]
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x00a7
            r15 = r17
            goto L_0x00a8
        L_0x00a7:
            r15 = 0
        L_0x00a8:
            if (r15 != 0) goto L_0x00ae
            if (r6 != r1) goto L_0x00ad
            return r5
        L_0x00ad:
            return r16
        L_0x00ae:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00b9
            if (r6 != r1) goto L_0x00b8
            return r5
        L_0x00b8:
            return r16
        L_0x00b9:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00be
            return r5
        L_0x00be:
            if (r3 == r13) goto L_0x00dd
            if (r3 == r11) goto L_0x00dd
            if (r3 < 0) goto L_0x00c9
            if (r3 >= r10) goto L_0x00c9
            r6 = r17
            goto L_0x00ca
        L_0x00c9:
            r6 = 0
        L_0x00ca:
            if (r6 != 0) goto L_0x00d9
            if (r9 > r3) goto L_0x00d3
            if (r3 >= r8) goto L_0x00d3
            r6 = r17
            goto L_0x00d4
        L_0x00d3:
            r6 = 0
        L_0x00d4:
            if (r6 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r6 = 0
            goto L_0x00db
        L_0x00d9:
            r6 = r17
        L_0x00db:
            if (r6 != 0) goto L_0x00df
        L_0x00dd:
            if (r3 != r12) goto L_0x00e0
        L_0x00df:
            return r16
        L_0x00e0:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00e7
            r15 = r17
            goto L_0x00e8
        L_0x00e7:
            r15 = 2
        L_0x00e8:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r4 = r4 + 2
        L_0x00ed:
            r6 = r7
            goto L_0x0008
        L_0x00f0:
            int r3 = r7 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 != r15) goto L_0x0183
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x0102
            if (r6 != r1) goto L_0x0101
            return r5
        L_0x0101:
            return r16
        L_0x0102:
            byte r7 = r0[r4]
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x010f
            r9 = r17
            goto L_0x0110
        L_0x010f:
            r9 = 0
        L_0x0110:
            if (r9 != 0) goto L_0x0116
            if (r6 != r1) goto L_0x0115
            return r5
        L_0x0115:
            return r16
        L_0x0116:
            byte r3 = r0[r3]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x011f
            r9 = r17
            goto L_0x0120
        L_0x011f:
            r9 = 0
        L_0x0120:
            if (r9 != 0) goto L_0x0126
            if (r6 != r1) goto L_0x0125
            return r5
        L_0x0125:
            return r16
        L_0x0126:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0138
            if (r6 != r1) goto L_0x0137
            return r5
        L_0x0137:
            return r16
        L_0x0138:
            if (r8 > r3) goto L_0x013f
            if (r3 >= r12) goto L_0x013f
            r7 = r17
            goto L_0x0140
        L_0x013f:
            r7 = 0
        L_0x0140:
            if (r7 == 0) goto L_0x0146
            if (r6 != r1) goto L_0x0145
            return r5
        L_0x0145:
            return r16
        L_0x0146:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x014b
            return r5
        L_0x014b:
            if (r3 == r13) goto L_0x016e
            if (r3 == r11) goto L_0x016e
            if (r3 < 0) goto L_0x0156
            if (r3 >= r10) goto L_0x0156
            r6 = r17
            goto L_0x0157
        L_0x0156:
            r6 = 0
        L_0x0157:
            if (r6 != 0) goto L_0x016a
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x0164
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x0164
            r6 = r17
            goto L_0x0165
        L_0x0164:
            r6 = 0
        L_0x0165:
            if (r6 == 0) goto L_0x0168
            goto L_0x016a
        L_0x0168:
            r6 = 0
            goto L_0x016c
        L_0x016a:
            r6 = r17
        L_0x016c:
            if (r6 != 0) goto L_0x0173
        L_0x016e:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0174
        L_0x0173:
            return r16
        L_0x0174:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x017b
            r15 = r17
            goto L_0x017c
        L_0x017b:
            r15 = 2
        L_0x017c:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r4 = r4 + 3
            goto L_0x00ed
        L_0x0183:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x0230
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x018f
            if (r6 != r1) goto L_0x018e
            return r5
        L_0x018e:
            return r16
        L_0x018f:
            byte r7 = r0[r4]
            int r9 = r4 + 1
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x019c
            r15 = r17
            goto L_0x019d
        L_0x019c:
            r15 = 0
        L_0x019d:
            if (r15 != 0) goto L_0x01a3
            if (r6 != r1) goto L_0x01a2
            return r5
        L_0x01a2:
            return r16
        L_0x01a3:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01ae
            r10 = r17
            goto L_0x01af
        L_0x01ae:
            r10 = 0
        L_0x01af:
            if (r10 != 0) goto L_0x01b5
            if (r6 != r1) goto L_0x01b4
            return r5
        L_0x01b4:
            return r16
        L_0x01b5:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01be
            r10 = r17
            goto L_0x01bf
        L_0x01be:
            r10 = 0
        L_0x01bf:
            if (r10 != 0) goto L_0x01c5
            if (r6 != r1) goto L_0x01c4
            return r5
        L_0x01c4:
            return r16
        L_0x01c5:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r9 = r9 << 12
            r3 = r3 ^ r9
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01db
            if (r6 != r1) goto L_0x01da
            return r5
        L_0x01da:
            return r16
        L_0x01db:
            if (r8 > r3) goto L_0x01e2
            if (r3 >= r12) goto L_0x01e2
            r7 = r17
            goto L_0x01e3
        L_0x01e2:
            r7 = 0
        L_0x01e3:
            if (r7 == 0) goto L_0x01e9
            if (r6 != r1) goto L_0x01e8
            return r5
        L_0x01e8:
            return r16
        L_0x01e9:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01f1
            if (r6 != r1) goto L_0x01f0
            return r5
        L_0x01f0:
            return r16
        L_0x01f1:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01f6
            return r5
        L_0x01f6:
            if (r3 == r13) goto L_0x021b
            if (r3 == r11) goto L_0x021b
            if (r3 < 0) goto L_0x0203
            r6 = 32
            if (r3 >= r6) goto L_0x0203
            r6 = r17
            goto L_0x0204
        L_0x0203:
            r6 = 0
        L_0x0204:
            if (r6 != 0) goto L_0x0217
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x0211
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x0211
            r6 = r17
            goto L_0x0212
        L_0x0211:
            r6 = 0
        L_0x0212:
            if (r6 == 0) goto L_0x0215
            goto L_0x0217
        L_0x0215:
            r6 = 0
            goto L_0x0219
        L_0x0217:
            r6 = r17
        L_0x0219:
            if (r6 != 0) goto L_0x0220
        L_0x021b:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0221
        L_0x0220:
            return r16
        L_0x0221:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0228
            r15 = r17
            goto L_0x0229
        L_0x0228:
            r15 = 2
        L_0x0229:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.f56620a
            int r4 = r4 + 4
            goto L_0x00ed
        L_0x0230:
            if (r6 != r1) goto L_0x0233
            return r5
        L_0x0233:
            return r16
        L_0x0234:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteString.codePointIndexToCharIndex(byte[], int):int");
    }

    public static final String commonBase64(okio.ByteString byteString) {
        return Base64.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(okio.ByteString byteString) {
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(okio.ByteString byteString, okio.ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        int i11 = 0;
        while (i11 < min) {
            byte b11 = byteString.getByte(i11) & 255;
            byte b12 = byteString2.getByte(i11) & 255;
            if (b11 == b12) {
                i11++;
            } else if (b11 < b12) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final void commonCopyInto(okio.ByteString byteString, int i11, byte[] bArr, int i12, int i13) {
        byte[] unused = ArraysKt___ArraysJvmKt.e(byteString.getData$okio(), bArr, i12, i11, i13 + i11);
    }

    public static final okio.ByteString commonDecodeBase64(String str) {
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new okio.ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final okio.ByteString commonDecodeHex(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = i11 * 2;
                bArr[i11] = (byte) ((decodeHexDigit(str.charAt(i12)) << 4) + decodeHexDigit(str.charAt(i12 + 1)));
            }
            return new okio.ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    public static final okio.ByteString commonEncodeUtf8(String str) {
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(okio.ByteString byteString, Object obj) {
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(okio.ByteString byteString, int i11) {
        return byteString.getData$okio()[i11];
    }

    public static final int commonGetSize(okio.ByteString byteString) {
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(okio.ByteString byteString) {
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final String commonHex(okio.ByteString byteString) {
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i11 = 0;
        for (byte b11 : byteString.getData$okio()) {
            int i12 = i11 + 1;
            cArr[i11] = getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = getHEX_DIGIT_CHARS()[b11 & 15];
        }
        return StringsKt__StringsJVMKt.q(cArr);
    }

    public static final int commonIndexOf(okio.ByteString byteString, byte[] bArr, int i11) {
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i11, 0);
        if (max > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public static final byte[] commonInternalArray(okio.ByteString byteString) {
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, okio.ByteString byteString2, int i11) {
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i11);
    }

    public static final okio.ByteString commonOf(byte[] bArr) {
        return new okio.ByteString(Arrays.copyOf(bArr, bArr.length));
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i11, okio.ByteString byteString2, int i12, int i13) {
        return byteString2.rangeEquals(i12, byteString.getData$okio(), i11, i13);
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, okio.ByteString byteString2) {
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final okio.ByteString commonSubstring(okio.ByteString byteString, int i11, int i12) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i12);
        boolean z11 = true;
        if (i11 >= 0) {
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter - i11 < 0) {
                    z11 = false;
                }
                if (!z11) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i11 == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new okio.ByteString(ArraysKt___ArraysJvmKt.i(byteString.getData$okio(), i11, resolveDefaultParameter));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final okio.ByteString commonToAsciiLowercase(okio.ByteString byteString) {
        int i11 = 0;
        while (i11 < byteString.getData$okio().length) {
            byte b11 = byteString.getData$okio()[i11];
            if (b11 < 65 || b11 > 90) {
                i11++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i11] = (byte) (b11 + 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b12 = copyOf[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        copyOf[i12] = (byte) (b12 + 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final okio.ByteString commonToAsciiUppercase(okio.ByteString byteString) {
        int i11 = 0;
        while (i11 < byteString.getData$okio().length) {
            byte b11 = byteString.getData$okio()[i11];
            if (b11 < 97 || b11 > 122) {
                i11++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i11] = (byte) (b11 + ISO7816.INS_CREATE_FILE);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b12 = copyOf[i12];
                    if (b12 >= 97 && b12 <= 122) {
                        copyOf[i12] = (byte) (b12 + ISO7816.INS_CREATE_FILE);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final byte[] commonToByteArray(okio.ByteString byteString) {
        byte[] data$okio = byteString.getData$okio();
        return Arrays.copyOf(data$okio, data$okio.length);
    }

    public static final okio.ByteString commonToByteString(byte[] bArr, int i11, int i12) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i12);
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, (long) resolveDefaultParameter);
        return new okio.ByteString(ArraysKt___ArraysJvmKt.i(bArr, i11, resolveDefaultParameter + i11));
    }

    public static final String commonToString(okio.ByteString byteString) {
        okio.ByteString byteString2;
        boolean z11 = true;
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            okio.ByteString byteString3 = byteString;
            String utf8 = byteString.utf8();
            String G = StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(utf8.substring(0, access$codePointIndexToCharIndex), "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString.getData$okio().length + " text=" + G + "…]";
            }
            return "[text=" + G + ']';
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(byteString.getData$okio().length);
            sb2.append(" hex=");
            okio.ByteString byteString4 = byteString;
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString4, 64);
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter + 0 < 0) {
                    z11 = false;
                }
                if (z11) {
                    if (resolveDefaultParameter == byteString.getData$okio().length) {
                        byteString2 = byteString4;
                    } else {
                        byteString2 = new okio.ByteString(ArraysKt___ArraysJvmKt.i(byteString.getData$okio(), 0, resolveDefaultParameter));
                    }
                    sb2.append(byteString2.hex());
                    sb2.append("…]");
                    return sb2.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
    }

    public static final String commonUtf8(okio.ByteString byteString) {
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(okio.ByteString byteString, Buffer buffer, int i11, int i12) {
        buffer.write(byteString.getData$okio(), i11, i12);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c11) {
        boolean z11 = true;
        if ('0' <= c11 && c11 < ':') {
            return c11 - '0';
        }
        char c12 = 'a';
        if (!('a' <= c11 && c11 < 'g')) {
            c12 = 'A';
            if ('A' > c11 || c11 >= 'G') {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c11);
            }
        }
        return (c11 - c12) + 10;
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(okio.ByteString byteString, byte[] bArr) {
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(okio.ByteString byteString, byte[] bArr, int i11) {
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i11), byteString.getData$okio().length - bArr.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(okio.ByteString byteString, int i11, byte[] bArr, int i12, int i13) {
        return i11 >= 0 && i11 <= byteString.getData$okio().length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i11, bArr, i12, i13);
    }

    public static final boolean commonStartsWith(okio.ByteString byteString, byte[] bArr) {
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
