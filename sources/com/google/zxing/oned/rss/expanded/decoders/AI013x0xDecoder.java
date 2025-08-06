package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

abstract class AI013x0xDecoder extends AI01weightDecoder {
    private static final int HEADER_SIZE = 5;
    private static final int WEIGHT_SIZE = 15;

    public AI013x0xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 60) {
            StringBuilder sb2 = new StringBuilder();
            encodeCompressedGtin(sb2, 5);
            encodeCompressedWeight(sb2, 45, 15);
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
