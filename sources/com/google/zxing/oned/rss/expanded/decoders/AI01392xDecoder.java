package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI01392xDecoder extends AI01decoder {
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    public AI01392xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() >= 48) {
            StringBuilder sb2 = new StringBuilder();
            encodeCompressedGtin(sb2, 8);
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
            sb2.append("(392");
            sb2.append(extractNumericValueFromBitArray);
            sb2.append(')');
            sb2.append(getGeneralDecoder().decodeGeneralPurposeField(50, (String) null).getNewString());
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
