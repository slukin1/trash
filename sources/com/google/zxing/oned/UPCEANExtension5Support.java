package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 5 && i11 < size; i13++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i11, UPCEANReader.L_AND_G_PATTERNS);
            sb2.append((char) ((decodeDigit % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (decodeDigit >= 10) {
                i12 |= 1 << (4 - i13);
            }
            if (i13 != 4) {
                i11 = bitArray.getNextUnset(bitArray.getNextSet(i11));
            }
        }
        if (sb2.length() == 5) {
            if (extensionChecksum(sb2.toString()) == determineCheckDigit(i12)) {
                return i11;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int determineCheckDigit(int i11) throws NotFoundException {
        for (int i12 = 0; i12 < 10; i12++) {
            if (i11 == CHECK_DIGIT_ENCODINGS[i12]) {
                return i12;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        for (int i12 = length - 2; i12 >= 0; i12 -= 2) {
            i11 += charSequence.charAt(i12) - '0';
        }
        int i13 = i11 * 3;
        for (int i14 = length - 1; i14 >= 0; i14 -= 2) {
            i13 += charSequence.charAt(i14) - '0';
        }
        return (i13 * 3) % 10;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r5.equals("90000") == false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String parseExtension5String(java.lang.String r5) {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L_0x004d
            r2 = 53
            if (r1 == r2) goto L_0x004a
            r2 = 57
            if (r1 == r2) goto L_0x0015
            goto L_0x004f
        L_0x0015:
            r1 = -1
            int r2 = r5.hashCode()
            switch(r2) {
                case 54118329: goto L_0x0035;
                case 54395376: goto L_0x002a;
                case 54395377: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            r0 = r1
            goto L_0x003e
        L_0x001f:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0028
            goto L_0x001d
        L_0x0028:
            r0 = 2
            goto L_0x003e
        L_0x002a:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0033
            goto L_0x001d
        L_0x0033:
            r0 = r4
            goto L_0x003e
        L_0x0035:
            java.lang.String r2 = "90000"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x003e
            goto L_0x001d
        L_0x003e:
            switch(r0) {
                case 0: goto L_0x0048;
                case 1: goto L_0x0045;
                case 2: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x004f
        L_0x0042:
            java.lang.String r5 = "0.00"
            return r5
        L_0x0045:
            java.lang.String r5 = "Used"
            return r5
        L_0x0048:
            r5 = 0
            return r5
        L_0x004a:
            java.lang.String r3 = "$"
            goto L_0x004f
        L_0x004d:
            java.lang.String r3 = "£"
        L_0x004f:
            java.lang.String r5 = r5.substring(r4)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L_0x006e
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "0"
            java.lang.String r5 = r1.concat(r5)
            goto L_0x0072
        L_0x006e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L_0x0072:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.UPCEANExtension5Support.parseExtension5String(java.lang.String):java.lang.String");
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() != 5 || (parseExtension5String = parseExtension5String(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, parseExtension5String);
        return enumMap;
    }

    public Result decodeRow(int i11, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb2 = this.decodeRowStringBuffer;
        sb2.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb2);
        String sb3 = sb2.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(sb3);
        float f11 = (float) i11;
        Result result = new Result(sb3, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, f11), new ResultPoint((float) decodeMiddle, f11)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
