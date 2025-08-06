package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public class Code93Writer extends OneDimensionalCodeWriter {
    @Deprecated
    public static int appendPattern(boolean[] zArr, int i11, int[] iArr, boolean z11) {
        return appendPattern(zArr, i11, iArr);
    }

    private static int computeChecksumIndex(String str, int i11) {
        int i12 = 0;
        int i13 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i12 += Code93Reader.ALPHABET_STRING.indexOf(str.charAt(length)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        return i12 % 47;
    }

    private static void toIntArray(int i11, int[] iArr) {
        for (int i12 = 0; i12 < 9; i12++) {
            int i13 = 1;
            if (((1 << (8 - i12)) & i11) == 0) {
                i13 = 0;
            }
            iArr[i12] = i13;
        }
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i11, i12, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
    }

    private static int appendPattern(boolean[] zArr, int i11, int[] iArr) {
        int length = iArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = i11 + 1;
            zArr[i11] = iArr[i12] != 0;
            i12++;
            i11 = i13;
        }
        return 9;
    }

    public boolean[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            int appendPattern = appendPattern(zArr, 0, iArr);
            for (int i11 = 0; i11 < length; i11++) {
                toIntArray(Code93Reader.CHARACTER_ENCODINGS[Code93Reader.ALPHABET_STRING.indexOf(str.charAt(i11))], iArr);
                appendPattern += appendPattern(zArr, appendPattern, iArr);
            }
            int computeChecksumIndex = computeChecksumIndex(str, 20);
            int[] iArr2 = Code93Reader.CHARACTER_ENCODINGS;
            toIntArray(iArr2[computeChecksumIndex], iArr);
            int appendPattern2 = appendPattern + appendPattern(zArr, appendPattern, iArr);
            toIntArray(iArr2[computeChecksumIndex(str + Code93Reader.ALPHABET_STRING.charAt(computeChecksumIndex), 15)], iArr);
            int appendPattern3 = appendPattern2 + appendPattern(zArr, appendPattern2, iArr);
            toIntArray(iArr2[47], iArr);
            zArr[appendPattern3 + appendPattern(zArr, appendPattern3, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
