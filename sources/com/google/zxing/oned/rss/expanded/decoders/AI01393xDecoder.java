package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01393xDecoder extends AI01decoder {
    private static final int FIRST_THREE_DIGITS_SIZE = 10;
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    public AI01393xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb2 = new StringBuilder();
            encodeCompressedGtin(sb2, 8);
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
            sb2.append("(393");
            sb2.append(extractNumericValueFromBitArray);
            sb2.append(')');
            int extractNumericValueFromBitArray2 = getGeneralDecoder().extractNumericValueFromBitArray(50, 10);
            if (extractNumericValueFromBitArray2 / 100 == 0) {
                sb2.append('0');
            }
            if (extractNumericValueFromBitArray2 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(extractNumericValueFromBitArray2);
            sb2.append(getGeneralDecoder().decodeGeneralPurposeField(60, (String) null).getNewString());
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
