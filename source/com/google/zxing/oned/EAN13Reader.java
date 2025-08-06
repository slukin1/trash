package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader extends UPCEANReader {
    public static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder sb2, int i11) throws NotFoundException {
        for (int i12 = 0; i12 < 10; i12++) {
            if (i11 == FIRST_DIGIT_ENCODINGS[i12]) {
                sb2.insert(0, (char) (i12 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i11 = iArr[1];
        int i12 = 0;
        for (int i13 = 0; i13 < 6 && i11 < size; i13++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i11, UPCEANReader.L_AND_G_PATTERNS);
            sb2.append((char) ((decodeDigit % 10) + 48));
            for (int i14 : iArr2) {
                i11 += i14;
            }
            if (decodeDigit >= 10) {
                i12 |= 1 << (5 - i13);
            }
        }
        determineFirstDigit(sb2, i12);
        int i15 = UPCEANReader.findGuardPattern(bitArray, i11, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i16 = 0; i16 < 6 && i15 < size; i16++) {
            sb2.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i15, UPCEANReader.L_PATTERNS) + 48));
            for (int i17 : iArr2) {
                i15 += i17;
            }
        }
        return i15;
    }

    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
