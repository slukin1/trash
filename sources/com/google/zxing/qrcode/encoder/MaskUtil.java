package com.google.zxing.qrcode.encoder;

final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z11) {
        int height = z11 ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z11 ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i11 = 0;
        for (int i12 = 0; i12 < height; i12++) {
            byte b11 = -1;
            int i13 = 0;
            for (int i14 = 0; i14 < width; i14++) {
                byte b12 = z11 ? array[i12][i14] : array[i14][i12];
                if (b12 == b11) {
                    i13++;
                } else {
                    if (i13 >= 5) {
                        i11 += (i13 - 5) + 3;
                    }
                    i13 = 1;
                    b11 = b12;
                }
            }
            if (i13 >= 5) {
                i11 += (i13 - 5) + 3;
            }
        }
        return i11;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i11 = 0;
        for (int i12 = 0; i12 < height - 1; i12++) {
            byte[] bArr = array[i12];
            int i13 = 0;
            while (i13 < width - 1) {
                byte b11 = bArr[i13];
                int i14 = i13 + 1;
                if (b11 == bArr[i14]) {
                    int i15 = i12 + 1;
                    if (b11 == array[i15][i13] && b11 == array[i15][i14]) {
                        i11++;
                    }
                }
                i13 = i14;
            }
        }
        return i11 * 3;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i11 = 0;
        for (int i12 = 0; i12 < height; i12++) {
            for (int i13 = 0; i13 < width; i13++) {
                byte[] bArr = array[i12];
                int i14 = i13 + 6;
                if (i14 < width && bArr[i13] == 1 && bArr[i13 + 1] == 0 && bArr[i13 + 2] == 1 && bArr[i13 + 3] == 1 && bArr[i13 + 4] == 1 && bArr[i13 + 5] == 0 && bArr[i14] == 1 && (isWhiteHorizontal(bArr, i13 - 4, i13) || isWhiteHorizontal(bArr, i13 + 7, i13 + 11))) {
                    i11++;
                }
                int i15 = i12 + 6;
                if (i15 < height && array[i12][i13] == 1 && array[i12 + 1][i13] == 0 && array[i12 + 2][i13] == 1 && array[i12 + 3][i13] == 1 && array[i12 + 4][i13] == 1 && array[i12 + 5][i13] == 0 && array[i15][i13] == 1 && (isWhiteVertical(array, i13, i12 - 4, i12) || isWhiteVertical(array, i13, i12 + 7, i12 + 11))) {
                    i11++;
                }
            }
        }
        return i11 * 40;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i11 = 0;
        for (int i12 = 0; i12 < height; i12++) {
            byte[] bArr = array[i12];
            for (int i13 = 0; i13 < width; i13++) {
                if (bArr[i13] == 1) {
                    i11++;
                }
            }
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i11 << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r1 != 0) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x0038;
                case 1: goto L_0x0039;
                case 2: goto L_0x0035;
                case 3: goto L_0x0031;
                case 4: goto L_0x002c;
                case 5: goto L_0x0025;
                case 6: goto L_0x001d;
                case 7: goto L_0x0014;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L_0x0014:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x0023
        L_0x001d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x0023:
            r1 = r1 & r0
            goto L_0x003b
        L_0x0025:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x003b
        L_0x002c:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x0038
        L_0x0031:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x003b
        L_0x0035:
            int r1 = r2 % 3
            goto L_0x003b
        L_0x0038:
            int r3 = r3 + r2
        L_0x0039:
            r1 = r3 & 1
        L_0x003b:
            if (r1 != 0) goto L_0x003e
            return r0
        L_0x003e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i11, int i12, int i13) {
        int min = Math.min(i13, bArr.length);
        for (int max = Math.max(i12, 0); max < min; max++) {
            if (bArr[max][i11] == 1) {
                return false;
            }
        }
        return true;
    }
}
