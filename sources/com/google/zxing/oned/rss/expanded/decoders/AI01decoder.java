package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder extends AbstractExpandedDecoder {
    public static final int GTIN_SIZE = 40;

    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    private static void appendCheckDigit(StringBuilder sb2, int i11) {
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < 13; i14++) {
            int charAt = sb2.charAt(i14 + i11) - '0';
            if ((i14 & 1) == 0) {
                charAt *= 3;
            }
            i13 += charAt;
        }
        int i15 = 10 - (i13 % 10);
        if (i15 != 10) {
            i12 = i15;
        }
        sb2.append(i12);
    }

    public final void encodeCompressedGtin(StringBuilder sb2, int i11) {
        sb2.append("(01)");
        int length = sb2.length();
        sb2.append('9');
        encodeCompressedGtinWithoutAI(sb2, i11, length);
    }

    public final void encodeCompressedGtinWithoutAI(StringBuilder sb2, int i11, int i12) {
        for (int i13 = 0; i13 < 4; i13++) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i13 * 10) + i11, 10);
            if (extractNumericValueFromBitArray / 100 == 0) {
                sb2.append('0');
            }
            if (extractNumericValueFromBitArray / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(extractNumericValueFromBitArray);
        }
        appendCheckDigit(sb2, i12);
    }
}
