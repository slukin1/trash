package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class UPCEReader extends UPCEANReader {
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    public static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] decodeMiddleCounters = new int[4];

    public static String convertUPCEtoUPCA(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c11 = cArr[5];
        switch (c11) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c11);
                sb2.append("0000");
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append("0000");
                sb2.append(c11);
                break;
        }
        if (str.length() >= 8) {
            sb2.append(str.charAt(7));
        }
        return sb2.toString();
    }

    private static void determineNumSysAndCheckDigit(StringBuilder sb2, int i11) throws NotFoundException {
        for (int i12 = 0; i12 <= 1; i12++) {
            for (int i13 = 0; i13 < 10; i13++) {
                if (i11 == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i12][i13]) {
                    sb2.insert(0, (char) (i12 + 48));
                    sb2.append((char) (i13 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public boolean checkChecksum(String str) throws FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    public int[] decodeEnd(BitArray bitArray, int i11) throws NotFoundException {
        return UPCEANReader.findGuardPattern(bitArray, i11, true, MIDDLE_END_PATTERN);
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
        determineNumSysAndCheckDigit(sb2, i12);
        return i11;
    }

    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.UPC_E;
    }
}
