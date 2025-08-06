package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i11 = iArr[1];
        for (int i12 = 0; i12 < 4 && i11 < size; i12++) {
            sb2.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i11, UPCEANReader.L_PATTERNS) + 48));
            for (int i13 : iArr2) {
                i11 += i13;
            }
        }
        int i14 = UPCEANReader.findGuardPattern(bitArray, i11, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i15 = 0; i15 < 4 && i14 < size; i15++) {
            sb2.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i14, UPCEANReader.L_PATTERNS) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_8;
    }
}
